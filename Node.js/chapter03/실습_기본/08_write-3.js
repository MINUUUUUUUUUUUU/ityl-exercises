const fs = require('fs');

const data = fs.readFileSync('./chapter03/실습_기본/example.txt', 'utf8');

if (fs.existsSync('text-1.txt')) {
  console.log('파일 존재');
} else {
  fs.writeFileSync('./text-1.txt', data);
}
