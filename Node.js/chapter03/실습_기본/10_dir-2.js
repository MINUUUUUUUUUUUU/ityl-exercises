const fs = require('fs');

if (fs.existsSync('./test2/test3/test4')) {
  console.log('디렉토리 존재');
} else {
  fs.mkdirSync('./test2/test3/test4', { recursive: true });
}
