//��ʼ��
var def="1";
function mover(object){
  //���˵�
  var mm=document.getElementById("m_"+object);
  mm.className="m_li_a";
  //��ʼ���˵�����Ч��
  if(def!=0){
    var mdef=document.getElementById("m_"+def);
    mdef.className="m_li";
  }
  //�Ӳ˵�
  var ss=document.getElementById("s_"+object);
  ss.style.display="block";
  //��ʼ�Ӳ˵�����Ч��
  if(def!=0){
    var sdef=document.getElementById("s_"+def);
    sdef.style.display="none";
  }
}

function mout(object){
  //���˵�
  var mm=document.getElementById("m_"+object);
  mm.className="m_li";
  //��ʼ���˵�
  if(def!=0){
    var mdef=document.getElementById("m_"+def);
    mdef.className="m_li_a";
  }
  //�Ӳ˵�
  var ss=document.getElementById("s_"+object);
  ss.style.display="none";
  //��ʼ�Ӳ˵�
  if(def!=0){
    var sdef=document.getElementById("s_"+def);
    sdef.style.display="block";
  }
}
