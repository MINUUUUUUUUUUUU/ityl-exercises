import order from './pizza_order.mjs'; //모재 (모듈 재사용)

//const pizzaList = ['치즈피자', '불고기피자', '페퍼로니피자'];
async function main() {
  //예외 처리 구문
  try {
    const fn = await order('양치');

    fn();
  } catch (err) {
    console.log(err);
  }
}

main();
