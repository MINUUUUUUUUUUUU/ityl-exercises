const fs = require('fs');

const data = fs.readFileSync('./chapter03/실습_기본/example.txt', 'utf-8'); //환경에 맞게 변경
console.log(data);
