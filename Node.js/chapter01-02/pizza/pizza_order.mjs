function pizzaOrder(pizzaName) {
  const pizzaList = ['치즈피자', '불고기피자', '페퍼로니피자'];

  // Promise 객체 : 비동기 코드 수행 후 결과 반환을 약속하는 객체
  return new Promise((resolve, reject) => {
    // 전받피리 (전달받은 피자가 list에 있다면)
    if (pizzaList.includes(pizzaName)) {
      // 성공 시 함반 (함수 반환)
      resolve(() => {
        console.log(`${pizzaName} 주문 완료!!`);

        setTimeout(() => {
          console.log(`${pizzaName} 배달 시작~`);
        }, 3000);
      });
    } else {
      // 실패 시 값반 (값 반환)
      reject(`주문 실패. ${pizzaName} 은/는 존재하지 않습니다`);
    }
  });
}

export default pizzaOrder;
