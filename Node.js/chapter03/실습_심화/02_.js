const fs = require('fs');

const readStream = fs.createReadStream('./chapter03/실습_심화/readMe.txt');
const writeStream = fs.createWriteStream('./chapter03/실습_심화/writeMe.txt');

readStream
  .on('data', (chunk) => {
    console.log('데이터 청크: ', chunk.length, chunk);
    writeStream.write(chunk);
  })
  .on('end', () => {
    console.log('끝났음');
    writeStream.end();
  })
  .on('error', (err) => {
    console.log(err);
  });
