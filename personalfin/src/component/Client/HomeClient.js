class HomeClient {
  static url = "";

  static async Portfolio() {
    var myHeaders = new Headers();
    myHeaders.append(
      "Authorization",
      "Bearer " + localStorage.getItem("token")
    );

    var requestOptions = {
      method: "GET",
      headers: myHeaders,
      redirect: "follow",
    };

    return fetch(this.url + "/portfolio", requestOptions).then((response) =>
      response.json()
    );
  }
}
export default HomeClient;
