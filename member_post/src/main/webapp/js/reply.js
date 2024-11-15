// const replyService =  {};
const replyService = (function(){ 
  const url = "/member_post/reply";

  function write(reply, callback){
    console.log(reply);
	if(callback)
	  callback();
  }
  function list(pno, callback){
    $.getJSON(url + "/list/" + pno).done(function(data){
      if(callback)
        callback(data);
    })

  }
  return {write, list}
  // return {write: write}
})();
