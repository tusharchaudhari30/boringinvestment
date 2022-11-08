class HomeClient {
  static url = "http://localhost:8080";

  static async Portfolio(username, password) {
    var requestOptions = {
      method: "GET",
      redirect: "follow",
    };

    return fetch(
      this.url + `/users/login?login=${username}&password=${password}`,
      requestOptions
    ).then((response) => response.text());
  }
}
export default HomeClient;
