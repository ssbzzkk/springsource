/**
 *
 */
//첨부파일 가져오기
fetch("/board/getAttachList?bno=" + bno)
  .then((Response) => {
    if (!Response.ok) {
      throw new Error("첨부물 없음");
    }
    return Response.json();
  })
  .then((data) => {
    console.log(data);
    showUploadedFile(data);
  })
  .catch((error) => console.log(error));

//수정버튼 클릭 해 폼 submit이 일어나면
//첨부파일 목록 수집하기
const modifyForm = document.querySelector("#modifyForm");

modifyForm.addEventListener("submit", (e) => {
  e.preventDefault();

  //첨부파일 정보를 hidden으로 담아서 폼 전송하기
  //게시글 내용이 작성이 다 되도 폼은 못가게 막기
  //첨부파일 정보 수집하기
  const lis = document.querySelectorAll(".uploadResult ul li");

  let str = "";
  lis.forEach((ele, idx) => {
    str +=
      "<input type='hidden' name='attachList[" +
      idx +
      "].uuid' value='" +
      ele.dataset.uuid +
      "'/>";
    str +=
      "<input type='hidden' name='attachList[" +
      idx +
      "].uploadPath' value='" +
      ele.dataset.path +
      "'/>";
    str +=
      "<input type='hidden' name='attachList[" +
      idx +
      "].fileName' value='" +
      ele.dataset.filename +
      "'/>";
    str +=
      "<input type='hidden' name='attachList[" +
      idx +
      "].fileType' value='" +
      ele.dataset.type +
      "'/>";
  });

  //수집한 태그 폼에 추가
  modifyForm.insertAdjacentHTML("beforeend", str);
  console.log("수정폼");
  console.log(modifyForm);

  modifyForm.submit();
});

//수정, 삭제 클릭 시 동작하는 폼

const form = document.querySelector("#operForm");

// 삭제 버튼 클릭 시 operForm 보내기
// /board/remove 전송
if (document.querySelector(".btn-danger")) {
  document.querySelector(".btn-danger").addEventListener("click", () => {
    form.action = "/board/remove";
    form.submit();
  });
}

// 목록 버튼 클릭 시 operForm 보내기
// /board/list 전송
// bno 제거
document.querySelector(".btn-secondary").addEventListener("click", () => {
  form.firstElementChild.remove();
  form.action = "/board/list";
  form.submit();
});
