class HomeClient {
  static url = "";

  static async Portfolio() {
    const myHeaders = new Headers();
    myHeaders.append(
      "Authorization",
      "Bearer " + localStorage.getItem("token")
    );

    const requestOptions = {
      method: "GET",
      headers: myHeaders,
      redirect: "follow",
    };

    return fetch(this.url + "/portfolio", requestOptions).then((response) =>
      response.json()
    );
  }

  static async LoadTransactionTable(page) {
    var myHeaders = new Headers();
    myHeaders.append(
      "Authorization",
      "Bearer " + localStorage.getItem("token")
    );
    const requestOptions = {
      method: "GET",
      headers: myHeaders,
      redirect: "follow",
    };

    return fetch(this.url + "/transaction/" + page, requestOptions).then(
      (response) => response.json()
    );
  }
  static async saveTransaction(assetName, ticker, amount, average, date) {
    const myHeaders = new Headers();
    myHeaders.append(
      "Authorization",
      "Bearer " + localStorage.getItem("token")
    );
    myHeaders.append("Content-Type", "application/json");

    const raw = JSON.stringify({
      assetName: assetName,
      ticker: ticker,
      average: average,
      quantity: amount,
      transactionDate: date,
    });

    const requestOptions = {
      method: "POST",
      headers: myHeaders,
      body: raw,
      redirect: "follow",
    };

    fetch(this.url + "/transaction", requestOptions)
      .then((response) => response.text())
      .then((result) => console.log(result))
      .catch((error) => console.log("error", error));
  }

  static async assetList(assetName) {
    const myHeaders = new Headers();
    myHeaders.append(
      "Authorization",
      "Bearer " + localStorage.getItem("token")
    );

    const requestOptions = {
      method: "GET",
      headers: myHeaders,
      redirect: "follow",
    };

    return fetch(
      this.url + "/asset/search?keyword=" + assetName,
      requestOptions
    ).then((response) => response.json());
  }
}

export default HomeClient;
