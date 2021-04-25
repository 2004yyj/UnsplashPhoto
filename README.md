# What Is Paging?
서버에서 모든 데이터를 불러와서 이를 모두 UI에서 처리하도록 하는 일반적인 리사이클러뷰와 달리
Paging은 Jetpack의 라이브러리로 페이징이 되어있는 API에서 이미지를 일부분씩 나누어 가져와서 리사이클러뷰에 출력하도록 하는 것이다.
## Paging3의 구조
![image](https://user-images.githubusercontent.com/18213322/115977933-3ca55b00-a5b7-11eb-85d1-99e4286dadd5.png)
### Repository
* PagingSource
    * 말 그대로 페이징할 소스를 가져오는 것으로, API 측에서 데이터를 가져오는 것이다.
* RemoteMediator
    * 이 놈은 PagingSource에서 갖고 온 데이터를 내부DB에 캐싱하는 것인데, 꼭 사용할 필요는 없다.
### ViewModel
* Pager
    * 위에 만든 것 중 캐싱이 필요하다면 RemoteMediator, 필요 없다면 PagingSource를 활용하여 내가 한꺼번에 몇 페이지를 가져올 것인지 설정한다.
    * UI에서 필요한 이미지가 있으면 관찰하도록 Coroutine의 flow, RxJava의 observable, flowable, LiveData 등등을 리턴할 수 있게 만들어져 있다.
### UI
* UI에서는 위에 만들어진 Pager을 관찰하여 페이지가 넘어갔을 때 PagerDataAdapter의 submitData(데이터)를 호출하도록 한다.
