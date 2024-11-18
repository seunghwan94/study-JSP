// const replyService =  {};
const replyService = (function(){ 
  const url = "/member_post/reply";

  function write(reply, callback){
    console.log(reply);
    // JSON.stringify() :: obj -> json String
    // JSON.parse() :: json -> obj

    const data = JSON.stringify(reply);
    $.post({url,data,}).done(function(data){
      console.log(data);
      if(callback)
        callback(data);
    })

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
