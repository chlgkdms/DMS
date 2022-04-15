const board = document.getElementById("board");
const body = document.getElementById("body");

let color = [
    "rgb(244,089,163)",
    "rgb(234,230,070)",
    "rgb(141,253,115)",
    "rgb(118,254,192)",
    "rgb(131, 245,239)",
];

let block = [];
let boardNum = 64;
let drag = false;

for (let i = 0; i < boardNum; i++){``
    let randomcolor;
    block[i] = document.createElement("div");
    block[i].classList.add("block");
    board.appendChild(block[i]);

    block[i].addEventListener("mouseover", ()=>{
        randomcolor = color[getRandom(0,4)];
        block[i].style.backgroundColor = randomcolor;
        block[i].style.boxshadow = `0px 0px 75px ${randomcolor}`
        if(drag) moveDraw(i,randomcolor);
    });

    block[i].addEventListener("mouseleave",()=>{
        block[i].style.backgroundColor = "#3a3a3a";
        block[i].style.boxshadow = "0px 0px 10px #3a3a3a";
    });

    block[i].addEventListener("click", () => {
        moveDraw(i, randomcolor);
    });
}

function moveDraw(a,b) {
    move(a,0,b,8);
    move(a,0,b,-8);
    move(a,0,b,1);
    move(a,0,b,-1);
}

function getRandom(min, max) {
    min = Math.ceil(min);
    max = Math.floor(max);
    return Math.floor(Math.random() * (max - min + 1)) + min;
}
function move(i, j, randomcolor, direction) {
    setTimeout(function () {
      if (direction == 8 || direction == -8) {
        if (i + j * direction >= 0 && i + j * direction <= 63) {
          draw(i, j, randomcolor, direction);
        }
      } // 상하로 칠하기
      else if (direction == 1) {
        if ((i + j * direction) % 8 != 0) {
          draw(i, j, randomcolor, direction);
        } else if (i % 8 == 0) {
          if (j < 7) {
            draw(i, j, randomcolor, direction);
          } // 횟수 제한
        } // 예외 처리
      } // 오른쪽 칠하기
      else if (direction == -1) {
        if ((i + 1 + j * direction) % 8 != 0) {
          draw(i, j, randomcolor, direction);
        } else if ((i + 1) % 8 == 0) {
          if (j < 7) {
            draw(i, j, randomcolor, direction);
          }
        }
      } // 왼쪽 칠하기
    }, j * 100); // 딜레이
  }
  function draw(i, j, randomcolor, direction) {
    block[i + j * direction].style.backgroundColor = randomcolor;
    block[i + j * direction].style.boxShadow = `0px 0px 75px ${randomcolor}`; // 색상 칠하기
    setTimeout(function () {
      block[i + j * direction].style.backgroundColor = "#3a3a3a";
      block[i + j * direction].style.boxShadow = "0px 0px 10px #3a3a3a";
    }, 500);
    move(i, j + 1, randomcolor, direction); // 다시 move함수 호출
  }

body.addEventListener("mousedown",() => {
    drag = true;
});
body.addEventListener("mouseup",() => {
    drag = false;
});
body.addEventListener("mouseleave",() => {
    drag = false;
});

