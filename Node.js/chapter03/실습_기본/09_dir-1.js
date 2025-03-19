const fs = require('fs');

if (fs.existsSync('./test')) {
  console.log('디렉토리 존재');
} else {
  fs.mkdirSync('./test', { recursive: true });
}
