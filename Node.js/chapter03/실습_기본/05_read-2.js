const fs = require('fs');

//환경에 맞게 경로 변경
fs.readFile('./chapter03/실습_기본/example.txt', 'utf-8', (err, data) => {
  if (err) {
    console.error(err);
  }
  console.log(data);
});
