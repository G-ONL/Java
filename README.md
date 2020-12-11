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
      
      //예제 2 ([if 조건1]예제 1에서 내가 가진 돈이 2700원이 안되면 Terra를 살 수 없다. 
      //        [else if 조건2]그러면 1700원짜리 필라이트 캔맥주를 살 수 있다.
      //        [else] 만약 1700원도 없으면 편의점을 나온다.)
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


   ```java
   //switch문의 기본 생김새
      switch( 대상 ){
        case 대상과 비교될 비교대상1 :
             실행될 코드(1)
             break;
        case 대상과 비교될 비교대상2 :
             실행될 코드(2)
             break;
      }
      
   //예시 1  (짤짤이를 만들기는 싫어 ! 내가 가지고 있는 돈 딱 맞는 맥주 사기)
      int myMoney = 2700
      switch( myMoney ){
         case 2700:
            buy(terra);  //terra를 사는 코드가 실행
            break;
         case 1700:
            buy(filite);
            break;
      }
      //그리고 switch문 밖으로 빠져나온다. (break문 때문에)
      
  
   //switch - default
      switch( 대상 ){
        case 대상과 비교될 비교대상1 :
             실행될 코드(1)
             break;
        case 대상과 비교될 비교대상2 :
             실행될 코드(2)
             break;
        default:
             아무 case에도 해당되지 않을 때 실행해줄 코드
             break;
      }
      
   //예시 2 (짤짤이를 만들기는 싫어 ! 내가 가지고 있는 돈 딱 맞는 맥주 사기, 돈 안되면 안사고 집 갈꺼야)
      int myMoney = 2500
      switch( myMoney ){
         case 2700:
            buy(terra); 
            break;
         case 1700:
            buy(filite);
            break;
         default :
            leave(store);  //편의점을 떠나는 코드 실행
            break;
      }
      // 그리고 switch문 밖으로 빠져나온다. (break문 때문에)
      
   //break 문이 없다면 case에 해당되는 그 코드부터 아래 다른 case에 해당하는 코드 모두 실행한다.
   ```

### 반복문

1. for문
   
   ```java
   //for문의 기본 모습
   for(초기식; 조건식; 증감식){
      반복 실행하고자 하는 코드
   }
   
   //예제 1 (terra를 10캔 살꺼야)
   for(int i = 1 ; i <= 10; i++) {
      buy(terra);
   }
   
   //forEach문의 기본 모습 ( 특징으로는 반복 횟수를 설정할 수는 없다. 포함된 개수만큼 for문을 수행)
   for( 해당되는 클래스,타입의 한 개의 객체(순환) : 리스트, 배열 등 한 개의 클래스,타입을 여러개 가지고 있는 객체){
      반복 실행하는 코드
   }
   
   //예제 2 (이 편의점에 있는 맥주 종류를 다 살꺼야)
   String[] beers = {"Terra", "FiLite", "Cass", "Hite"}
   for(String beer : beers){
      buy(beer); // Terra, FiLite, Cass, Hite가 모두 beer에 맵핑되면서 한 번씩 실행!
   }
   
   //문제 1 (편의점 맥주를 사고 배열에서 삭제해버리기)
   List<String> beers = new ArrayList<>(Arrays.asList("Terra","FiLite","Cass","Hite"));
    for (int i = 0; i < beers.size(); i++) {
      buy(beers.get(i));
      beers.remove(i);
    }
   
    이렇게 수행할 경우 어떤 맥주를 살 수 있을까? 
    beers.size()가 4이니까 4번 돌지 않을까?
    그러면 다 살 수 있는거 아닌가??
    아마 그대로 실행을 해보면 "Terra"와 "Cass"만 살 수 있는 것을 확인 할 수 있을 것이다.
    
    
    //해답 1
    List<String> beers = new ArrayList<>(Arrays.asList("Terra", "FiLite", "Cass", "Hite"));
    for (int i = beers.size() - 1; i >= 0; i--) {
      System.out.println(beers.get(i));
      beers.remove(i);
    }
    
    이유는  beers.size()가 remove 할 때 마다 줄어든다는 것이다.
    문제 1에서 int i =0 으로 시작할 때 beers.size()는 4 입니다.
    Terra를 살 것이고,  Terra가 list에서 없어집니다. 남아있는 list는 FiLite, Cass, Hite죠
    i가 1증가해서 i = 1일 때는 beers.size()는 3 입니다.
    위에서 남아있는 list(FiLite, Cass, Hite )에서 1번 인덱스 자리는 Cass가 되겠죠.
    그래서 Cass도 사고, 리스트에서 제거가 되고 남아있는 list에는 FiLite, Hite가 있겠죠.
    i가 1증가해서 i = 2일 때 beers.size()는 2입니다.
    size()보다 i가 작아야 하기 때문에 for문 조건식에 만족을 하지 못해 그대로 종료하게 됩니다.
    
   ```
2. while문
