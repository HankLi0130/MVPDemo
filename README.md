# Android MVP
本範例使用登入頁面來介紹MVP架構，專案內有一個LoginActivity，裡面有一個登入的頁面，流程為輸入帳號、密碼後按下登入，並透過API判斷是否登入成功


## MVP架構
![架構圖](https://github.com/HankLi0130/MVPDemo/blob/master/diagram/MVP_Architecture_Diagram.png?raw=true)

#### 職責簡介

**View**: Activity與Fragment，能使用Android的Class

**Presenter**: 邏輯組裝區，只使用Java的Class

**Model**: 資料的複合服務區與純服務區

<br />

#### 流程介紹
1. **輸入帳號、密碼後，按下登入** <br />
View與Presenter透過自定義的Contract Interface溝通，將登入資料(username, password)傳給Presenter

2. **透過API判斷是否登入成功** <br/>
Presenter透過Repository去跟各相關的服務(API, Database, Sharedpreferences...)換取資料後，Presenter得到結果後，通知給View做相對應的動作

## 參考
[googlesamples/android-architecture](https://github.com/googlesamples/android-architecture)