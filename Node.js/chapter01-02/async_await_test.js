async function init() {
  const response = await fetch('https://jsonplaceholder.typicode.com/users');

  if (response.ok) {
    const result = await response.json();
    console.log(result);
  }

  console.log('프로그램 종료');
}

init();
