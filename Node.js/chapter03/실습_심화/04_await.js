const fs = require('fs').promises;

async function testAwait() {
  try {
    const fileDir = await fs.readdir('./');
    console.log(fileDir);
  } catch (err) {
    console.log(err);
  }
}

testAwait();
