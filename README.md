<div align="center">
  <h3>2023 UHS Computer Engineering Capstone Design </h3>
  <h3>AI기반 자세교정/평가 솔루션 Pro,pose(프로,포즈)</h3>
</div>
<br><br>



<div align="center">
  <img src="https://user-images.githubusercontent.com/96610952/220712126-080e101f-2260-4445-b3d8-35dd28ae65c7.svg" width="600px">
</div>

---
<br>
<div align="center">
  <div align="center">
    <img src="https://img.shields.io/badge/python-3.9.2rc1-blue">
    <br>
    <img src="https://img.shields.io/badge/mediapipe-0.9.0.1-pink">
    <img src="https://img.shields.io/badge/opencv-4.7.0.68-pink">
    <img src="https://img.shields.io/badge/ffmpeg-0.2.0-pink">
    <img src="https://img.shields.io/badge/numpy-1.24.1-pink">
    <img src="https://img.shields.io/badge/pandas-1.5.3-pink">
    <br>
    <img src="https://img.shields.io/badge/dtaidistance-2.3.10-pink">
    <img src="https://img.shields.io/badge/-with edited dtw.py-pink">
  </div>
 </div>
<br>

---

<br><br>
<div align="center">
  <h3> ★시스템 구성도★ </h3>
  본 프로젝트에서‘프로,포즈’의 전반적인 시스템은 웹 클라이언트를 통해 제공됩니다. 클라이언트는 사용자가 촬영한 동작 영상을 서버로 업로드 하거나, 분석 이력을 확인할 수 있는 기능을 제공하며, 서버에서는 업로드 된 영상을 AI 모델을 활용하여 분석한 후, 사용자에게 다양한 형태의 피드백을 제공합니다.
  <br>
  <br>
  아래 그림은 대략적인 시스템 구성도를 그림으로 나타낸 것입니다.
  해당 웹 애플리케이션의 인터페이스, 서버, AI 모델을 제작하기 위해 사용된 언어에는 각각 React, Spring, Python이 있습니다.
  <br>
  <br>
  <img src="https://github.com/junyoun99/Propose-Spring-BackEnd/assets/105766683/c7de5b3c-6b18-4c8b-b5e7-4f34a6de8748.png" width="40%">
  <img src="https://github.com/junyoun99/Propose-Spring-BackEnd/assets/105766683/d5590602-021b-4197-99a1-e3e41adcc246.png" width="50%">
  <br><br><br><br><br>
  
  
  ---
<br><br>
<div align="center">
  <h2> ★시스템 구현★ </h2>

  <br><br>
<div align="center">
  <h3> ★1) 초기화면★ </h3>
아래 사진은 웹 클라이언트의 첫 화면입니다. 상단 우측에는 메인, 로그인, 회원가입 페이지로 전환할 수 있는 버튼이 있습니다.
  <br>
  <br>
  <img src="https://github.com/junyoun99/Propose-Spring-BackEnd/assets/105766683/5a0e6980-930c-4e5b-a1dd-e27d14529d01.png" width="70%">
  <br><br><br><br><br>
  
  
  ---

  <br><br>
<div align="center">
  <h3> ★2) 로그인/회원가입 화면★ </h3>
아래 사진은 웹 클라이언트의 첫 화면입니다. 상단 우측에는 메인, 로그인, 회원가입 페이지로 전환할 수 있는 버튼이 있습니다.
  <br>
  회원 계정이 있는 경우 아이디와 패스워드 입력을 통해 로그인 할 수 있고, 그렇지 않은 경우 회원가입 페이지에서 아이디, 이메일, 패스워드 입력을 통해 회원가입 후 로그인을 수행할 수 있습니다.
  <br>
  <br>
  <img src="https://github.com/junyoun99/Propose-Spring-BackEnd/assets/105766683/02cf218c-11fc-4c9c-8417-479c924467ba)8b-b5e7-4f34a6de8748.png" width="70%">
  <img src="https://github.com/junyoun99/Propose-Spring-BackEnd/assets/105766683/aab40c14-672f-42be-b1fa-ed8fa636435f.png" width="70%">
  <br><br><br><br><br>
  
  
  ---

  <br><br>
<div align="center">
  <h3> ★3) 로그인 후 운동 선택 화면★ </h3>
로그인을 완료하면 아래 사진과 같이 메인 화면 상단 구성이 달라집니다. 기존에 있던 메인, 로그인, 회원가입 버튼이 메인, 로그아웃, 재활운동하기, 업로드, 마이페이지로 변경됩니다. 로그아웃 버튼 클릭 시 로그인 전 초기화면으로 돌아가게 되고, 재활운동하기 버튼을 클릭하면 운동을 선택할 수 있는 페이지로 전환됩니다.
  <br>
  <br>
  <img src="https://github.com/junyoun99/Propose-Spring-BackEnd/assets/105766683/a591f97c-a6af-4258-9d05-93b122b3758e.png" width="70%">
  <br><br>
  아래의 운동 선택 페이지를 통해 사용자는 피드백을 원하는 부위를 직접 선택할 수 있습니다. 본 프로젝트에서는 부상이 자주 발생하는 어깨, 허리, 발목 세 가지로 부위를 나누었습니다.
  <br><br>
  <img src="https://github.com/junyoun99/Propose-Spring-BackEnd/assets/105766683/cac7e14b-8dd7-422e-bbcd-c0d928cad183.png" width="70%">
  <img src="https://github.com/junyoun99/Propose-Spring-BackEnd/assets/105766683/d647bfca-30b3-4bd4-bec9-f67a5e6d2a3c.png" width="70%">
  <br><br><br><br><br>
  
  
  ---

  
  <br><br>
<div align="center">
  <h3> ★4) 운동 녹화 화면★ </h3>
  운동 녹화 페이지에서는 사용자가 본인의 카메라를 통해 녹화를 할 수 있습니다. 화면 좌측에는 교범 영상이 있고, 화면 중앙의‘촬영준비’버튼 클릭 시 화면 우측에 사용자의 모습을 녹화할 준비를 합니다. ‘촬영시작’버튼을 클릭하면 사용자의 동작 전 준비를 위해 3초의 지연시간 뒤 교범 영상과 녹화가 동시에 시작됩니다. 녹화를 마친 뒤‘다운로드’버튼과‘결과보기’버튼을 순차적으로 누르면 결과 페이지로 넘어가게 됩니다.
  <br>
  <br>
  <img src="https://github.com/junyoun99/Propose-Spring-BackEnd/assets/105766683/bb993c82-efe7-44bd-b763-b1a0c72bb6df.png" width="70%">
  <br><br><br><br><br>
  
  
  ---

  <br><br>
<div align="center">
  <h3> ★5) 결과 페이지 화면★ </h3>
아래 사진에서 확인할 수 있듯이, 화면 상단부터 차례대로 사용자의 이름, 분석된 결과 이미지, 총 스코어, 피드백이 나오고,‘기록 저장하기’버튼을 통해 사용자의 결과를 저장할 수 있습니다. 해당 페이지는 화면 상단‘업로드’버튼을 통해서 다시 확인할 수 있습니다.
  <br>
  <br>
  <img src="https://github.com/junyoun99/Propose-Spring-BackEnd/assets/105766683/a9b26f67-851e-4c9f-b9c3-5d05af1159aa.png" width="70%">
  <br><br><br><br><br>
  
  
  ---

   <br><br>
<div align="center">
  <h3> ★5) 마이 페이지 화면★ </h3>
마이 페이지에는 저장된 기록을 토대로 만들어진 각 주차별 점수 그래프와 사용자의 출석률을 확인할 수 있는 출석 캘린더가 배치되어 있습니다. 캘린더 내 금일 날짜에 있는‘출석’버튼을 클릭하면 출석일이 하루 올라가게 됩니다.
  <br>
  <br>
  <img src="https://github.com/junyoun99/Propose-Spring-BackEnd/assets/105766683/0568d7f6-a912-47f7-b682-06a77947ff20.png" width="70%">
  <br><br><br><br><br>
  
  
  ---
