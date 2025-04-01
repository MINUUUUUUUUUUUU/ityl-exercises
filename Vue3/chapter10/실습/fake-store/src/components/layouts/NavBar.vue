<style></style>

<template>
  <div>
    <nav class="navbar navbar-expand-sm bg-primary navbar-dark">
      <div class="container-fluid">
        <RouterLink class="navbar-brand" to="/">
          <i class="fa-solid fa-home"></i> Fake Store
        </RouterLink>

        <!-- 햄버거 버튼 -->
        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#collapsibleNavbar"
        >
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="collapsibleNavbar">
          <!-- navigation - 왼쪽  -->
          <ul class="navbar-nav me-auto">
            <li class="nav-item">
              <RouterLink class="nav-link" to="/electronics"
                ><i class="fa-solid fa-cart-shopping"></i> 가전</RouterLink
              >
            </li>
            <li class="nav-item">
              <RouterLink class="nav-link" to="/jewelery"
                ><i class="fa-solid fa-gem"></i> 주얼리</RouterLink
              >
            </li>
            <li class="nav-item">
              <RouterLink class="nav-link" to="/mens-clothing"
                ><i class="fa-solid fa-user-tie"></i> 남성의류</RouterLink
              >
            </li>
            <li class="nav-item">
              <RouterLink class="nav-link" to="women-clothing"
                ><i class="fa-solid fa-person-dress"></i> 여성의류</RouterLink
              >
            </li>
          </ul>

          <!-- navigation - 오른쪽  -->
          <!-- <ul class="navbar-nav">
            <li class="nav-item">
              <a class="nav-link" href="#">
                <i class="fa-solid fa-circle-user avatar"></i>
                admin
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">
                <i class="fa-solid fa-right-from-bracket"></i>
                로그아웃
              </a>
            </li>
          </ul> -->
        </div>
      </div>
    </nav>
  </div>
</template>

<script>
export default {};
</script>
