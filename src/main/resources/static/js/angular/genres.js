// alert("a")
let host = "http://localhost:8080/rest";
const app = angular.module("genresApp", []);

app.controller('genresCtrl', function($scope, $http) {
    $scope.form = {}
    $scope.items = []
    $scope.reset = function(){
        
        $scope.form = {};
        $scope.key = null;
    }
   

    $scope.load_all = function(){
        var url = `${host}/genres`;
        $http.get(url).then(resp => {
            $scope.items = resp.data;
            console.log("Success", resp);
            
        }).catch(error => {
            console.log("Error", error);
        })
    }

    $scope.edit = function(key){
        var url = `${host}/genres/${key}`;
        $http.get(url).then(resp => {
            $scope.form = resp.data;
            $scope.key = key;
            console.log("Success", resp);
            
        }).catch(error => {
            console.log("Error", error);
        });
        
    };
    
    $scope.save = function() {

    }

    $scope.create = function () {
        var url = `${host}/genres`;
    
        // Tạo đối tượng genre từ form
        var genre = {
            name: $scope.form.name
        };
    
        // Gửi yêu cầu POST đến máy chủ Spring Boot
        $http.post(url, genre).then(
            function (response) {
                // Xử lý khi thành công
                $scope.items.push(response.data);
                $scope.reset();
                alert("Success");
                console.log(resp);
            },
            function (error) {
                // Xử lý khi có lỗi
                alert("Error");
                console.log("error",error);
            }
        );
    };
    
    $scope.update = function(){
        var item = angular.copy($scope.form);
        var url = `${host}/genres/${$scope.form.id}`; 
        $http.put(url, item).then(resp =>{
            var index = $scope.items.findIndex(item => item.id == $scope.form.id );
            $scope.items[index] = resp.data;
            $scope.reset();
            alert("Success");
            console.log("Success", resp)
        }).catch(error => {
            console("Error", error)
        });
    }

    


    $scope.delete = function(id){
        var url = `${host}/genres/${id}`; 
        $http.delete(url).then(resp =>{
            var index = $scope.items.findIndex(item => item.id == id);
            $scope.items.splice(index, 1);
            $scope.reset();
            alert("Success")
        }).catch(error =>{
            alert.log("Error", error)
        })
    }

    $scope.load_all();
    $scope.reset();
    


})
   
    