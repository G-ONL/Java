# 제어문 (선택문 / 반복문)


### 선택문

1. if문
   
   ```java
   
      //if문의 기본 생김새
      if(조건문){
        조건에 해당되었을 때 수행될 코드
      }
      
      //예제 1 (내가 가지고 있는 돈이 3000원인데 이러면 2700원짜리 Terra 캔맥주를 살 수 있다.)
      int myMoney = 3000;
      
      if( myMoney >= 2700 ){
        buy(terra);
      }
      
      //if - else if - else 
      if(조건1){
        조건 1에 해당이 되면 수행될 코드
      }else if(조건2){
        조건 1에는 해당이 되지 않고 조건 2에 해당이 되면 수행이 될 코드
      }else{
        조건 1, 조건 2에 해당이 되지 않으면 수행될 코드
      }
      
      //예제 2 (예제 1에서 내가 가진 돈이 2700원이 안되면 Terra를 살 수 없다. 그러면 1700원짜리 필라이트 캔맥주를 살 수 있다. 만약 1700원도 없으면 편의점을 나온다.)
      int myMoney = 2500;
      
      if( myMoney >= 2700 ) {
         buy(terra);
      }else if( myMoney >= 1700){
         buy(filite);  // 2500원이 있으니 FiLite 캔맥주를 살 수 있다.
      }else{
         leave(store);
      }
      
   ```
   
  
2. switch문

### 반복문

1. for문
2. while문
