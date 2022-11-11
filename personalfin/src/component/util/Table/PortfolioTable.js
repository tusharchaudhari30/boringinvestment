import React, { Component } from "react";

//{"invested":1000000.0,"holding":6467400.0,"stockList":[{"assetName":"TCS","ticker":"TCS.NS","average":500.0,"price":3233.7,"quantity":2000}]}
export default class PortfolioTable extends Component {
  render() {
    return (
      <div className="text-white p-5 w-full overflow-x-auto text-sm">
        <table>
          <tbody>
            <tr>
              <th className="px-2 py-1 border-slate-400 border">No.</th>
              <th className="px-2 py-1 border-slate-400 border">Asset Name</th>
              <th className="px-2 py-1 border-slate-400 border">Ticker</th>
              <th className="px-2 py-1 border-slate-400 border">Average</th>
              <th className="px-2 py-1 border-slate-400 border">Quantity</th>
              <th className="px-2 py-1 border-slate-400 border">Holding</th>
            </tr>
            {this.props.data.map((stock, key) => {
              return (
                <React.Fragment key={key}>
                  <tr>
                    <td className="px-3 py-3 border-slate-600 border">
                      {key + 1}
                    </td>
                    <td className="px-2 py-3 border-slate-600 border">
                      {stock.assetName}
                    </td>
                    <td className="px-2 py-3 border-slate-600 border">
                      {stock.ticker}
                    </td>
                    <td className="px-2 py-3 border-slate-600 border">
                      {stock.average}
                    </td>
                    <td className="px-2 py-3 border-slate-600 border">
                      {stock.quantity}
                    </td>
                    <td className="px-2 py-3 border-slate-600 border">
                      {(stock.quantity * stock.price).toFixed(2)}
                    </td>
                  </tr>
                </React.Fragment>
              );
            })}
          </tbody>
        </table>
        <div className="flex flex-wrap justify-center p-5">
          <div className="border p-2 px-4 border-slate-400 mx-2">{"<"}</div>
          <div className="border p-2 px-4 border-slate-400 mx-2">{">"}</div>
        </div>
      </div>
    );
  }
}
