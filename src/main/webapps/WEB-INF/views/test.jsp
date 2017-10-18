<!DOCTYPE html>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script>
        $(document).ready(function(){
            $("button").click(function(){
                $.ajax({
                    url:"http://localhost:8520/rest/test/ajax",
                    type:"GET",
                    dataType:"json",
                    success:function(data){
//                        console.log(data);
                        if(data)
                        {
//                            alert("success");
                            $('#xyz').hide();
                            $('#xyzz').show();
                        }
                    }
                })
            });
        });
    </script>
</head>
<body>

<div id="div1"><h2>Let jQuery AJAX Change This Text</h2></div>

<button id="xyz">Get External Content</button>
<button style="display:none;" id="xyzz">Approved</button>

</body>
</html>
