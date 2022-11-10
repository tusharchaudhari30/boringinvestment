import React, { Component } from "react";
import HomeClient from "../../Client/HomeClient";
import Button1 from "../buttons/Button1";
import ModalTransaction from "../modal/ModalTransaction";

export default class TransactionTable extends Component {
  state = {
    transactionModalVisible: false,
    transactions: null,
    backendPage: 0,
  };
  changeTransactionVisible = () => {
    this.setState({
      transactionModalVisible: !this.state.transactionModalVisible,
    });
  };

  componentDidMount() {
    HomeClient.LoadTransactionTable(this.state.backendPage).then((data) =>
      this.setState({ transactions: data })
    );
  }

  nextPage() {
    this.setState({
      backendPage: this.state.backendPage + 1,
    });
    HomeClient.LoadTransactionTable(this.state.backendPage + 1).then((data) => {
      this.setState({
        transactions: data,
      });
    });
  }
  prevPage() {
    if (this.state.backendPage === 0) return;
    this.setState({
      backendPage: this.state.backendPage - 1,
    });
    HomeClient.LoadTransactionTable(this.state.backendPage - 1).then((data) => {
      this.setState({
        transactions: data,
      });
    });
  }

  loadTable() {
    if (this.state.transactions === null) {
      return (
        <React.Fragment>
          <tr>
            <td className="px-2 py-1 border-slate-400 border">No</td>
            <td className="px-2 py-1 border-slate-400 border">Ticker</td>
            <td className="px-2 py-1 border-slate-400 border">Asset Name</td>
            <td className="px-2 py-1 border-slate-400 border">Average</td>
            <td className="px-2 py-1 border-slate-400 border">Quantity</td>
            <td className="px-2 py-1 border-slate-400 border">Date</td>
            <td className="px-2 py-1 border-slate-400 border">Edit</td>
          </tr>
        </React.Fragment>
      );
    }
    return (
      <React.Fragment>
        {this.state.transactions.map((transaction, key) => {
          return (
            <tr key={key}>
              <td className="px-2 py-1 border-slate-600 border">
                {key + this.state.backendPage * 5 + 1}
              </td>
              <td className="px-2 py-1 border-slate-600 border">
                {transaction.ticker}
              </td>
              <td className="px-2 py-1 border-slate-600 border">
                {transaction.assetName}
              </td>
              <td className="px-2 py-1 border-slate-600 border">
                {transaction.average}
              </td>
              <td className="px-2 py-1 border-slate-600 border">
                {transaction.quantity}
              </td>
              <td className="px-2 py-1 border-slate-600 border">
                {new Date(transaction.transactionDate).toLocaleDateString(
                  "en-US"
                )}
              </td>
              <td className="px-2 py-1 border-slate-600 border">
                <Button1 value={"Edit"} />
              </td>
            </tr>
          );
        })}
      </React.Fragment>
    );
  }

  render() {
    return (
      <div className="text-white p-5 w-full overflow-x-auto text-sm">
        {this.state.transactionModalVisible && (
          <ModalTransaction
            changeTransactionVisible={this.changeTransactionVisible}
          />
        )}
        <div className="pb-5 flex">
          <Button1
            value={"Add Transaction"}
            onpress={this.changeTransactionVisible}
          ></Button1>
        </div>
        <table>
          <tbody>
            <tr>
              <th className="px-2 py-1 border-slate-400 border">No</th>
              <th className="px-2 py-1 border-slate-400 border">Ticker</th>
              <th className="px-2 py-1 border-slate-400 border">Asset Name</th>
              <th className="px-2 py-1 border-slate-400 border">Average</th>
              <th className="px-2 py-1 border-slate-400 border">Quantity</th>
              <th className="px-2 py-1 border-slate-400 border">Date</th>
              <th className="px-2 py-1 border-slate-400 border">Edit</th>
            </tr>
            {this.loadTable()}
          </tbody>
        </table>
        <div className="flex flex-wrap justify-center p-5">
          <div
            className="border p-2 px-4 border-slate-400 mx-2 hover:bg-slate-200 hover:text-black cursor-pointer"
            onClick={() => this.prevPage()}
          >
            {"<"}
          </div>
          <div
            className="border p-2 px-4 border-slate-400 mx-2 hover:bg-slate-200 hover:text-black cursor-pointer"
            onClick={() => this.nextPage()}
          >
            {">"}
          </div>
        </div>
      </div>
    );
  }
}
