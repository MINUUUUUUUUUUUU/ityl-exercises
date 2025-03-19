const fs = require('fs');

const data = fs.readFileSync('./chapter03/실습_기본/example.txt', 'utf8');
fs.writeFileSync('./text-1.txt', data);
