// const parsedPath = Path.parse(__filename);

const fs = require('fs');

let files = fs.readdirSync('./');
console.log(files);
