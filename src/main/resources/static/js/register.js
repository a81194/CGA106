/**
 * Get user input data
 */

/**
 * Get with param
 */
// $('#sent-get').click(e => {
//     e.preventDefault();
//     const empId = $('#empId').val();
//     fetch(`/emp/get-by-id?id=${empId}`, {
//         method: 'GET',
//     }).then((response) => {
//         response.text().then(res => {
//             $('#sent-get-p').text(`id ${empId}'s name is ${res}`);
//         });
//     });
// });

/**
 * Post
 */
let registerData={};
$('#mem-reg').click((e) => {
    e.preventDefault();
    // 取得user輸入的資料
    registerData.memName=document.getElementById('mem_name').value;
    registerData.memEmail=document.getElementById("mem_email").value;
    registerData.memPassword=document.getElementById("mem_password").value;
    registerData.memPhone=document.getElementById("mem_phone").value;
    registerData.memAddress=document.getElementById("mem_address").value;
    registerData.memBirthday=document.getElementById("mem_birthday").value;
    registerData.memGender=document.querySelector('input[name="genderOptions"]:checked').value;
    console.log(registerData);
    fetch(`/mem/reg`, {
        method: 'POST',
        body: JSON.stringify(registerData),
        headers: {'Content-Type': 'application/json'},
    }).then(response => response.json())
    .then(data => console.log(data))
    .catch(error => console.error(error));
});

$('form').submit(e => {
    e.preventDefault();

    // console.log(JSON.stringify(registerData))

    fetch(e.target.action, {
        method: 'POST',
        body: JSON.stringify(registerData),
        headers: {'Content-Type': 'application/json'}
    })
    .then(response => {
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        return response.json();
      })
      .then(data => {
        console.log(data);
      })
      .catch(error => {
        console.error('There was a problem with the fetch operation:', error);
      });    
});
