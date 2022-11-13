class LoginClient {
    static url = "http://localhost:8080";

    static async login(username, password) {
        let requestOptions = {
            method: "GET",
            redirect: "follow",
        };

        return fetch(
            this.url + `/users/login?login=${username}&password=${password}`,
            requestOptions
        ).then((response) => response.text());
    }

    static async validate() {
        let myHeaders = new Headers();
        myHeaders.append(
            "Authorization",
            "Bearer " + localStorage.getItem("token")
        );

        let requestOptions = {
            method: "GET",
            headers: myHeaders,
            redirect: "follow",
        };

        return fetch(this.url + "/hello/me", requestOptions).then(
            (response) => response.status === 200
        );
    }
}

export default LoginClient;
