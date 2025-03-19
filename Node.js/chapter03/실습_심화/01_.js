// const path = require('path');
const fs = require('fs');

const readStream = fs.createReadStream('./chapter03/실습_심화/readMe.txt');

readStream
  .on('data', (chunk) => {
    console.log('데이터 청크: ', chunk.length, chunk);
  })
  .on('end', () => {
    console.log('끝났음');
  })
  .on('error', (err) => {
    console.log(err);
  });
