const path = require('path');

const fullpath = path.join('some', 'work', 'ex.txt');
console.log(fullpath);

// -----

const dir = path.dirname(__filename);
console.log(`파일 절대 경로: ${__filename}`);
console.log(`경로만: ${dir}`);

// -----

const filename01 = path.basename(__filename);
const filename02 = path.basename(__filename, '.js');

console.log(`파일 이름: ${filename01}`);
console.log(`파일 이름(확장자 제외): ${filename02}`);

// -----

const extname = path.extname(__filename);

console.log(`파일 확장자: ${extname}`);

// -----

const allpath = path.parse(__filename);

console.log(allpath);
