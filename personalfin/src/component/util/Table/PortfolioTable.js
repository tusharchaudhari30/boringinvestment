import React, { Component } from "react";
import Button1 from "../buttons/Button1";
import ModalTransaction from "../modal/ModalTransaction";

export default class PortfolioTable extends Component {
  render() {
    return (
      <div className="text-white p-5 w-full overflow-x-auto text-sm">
        <table>
          <tbody>
            <tr>
              <th className="px-2 py-1 border-slate-400 border">No.</th>
              <th className="px-2 py-1 border-slate-400 border">Ticker</th>
              <th className="px-2 py-1 border-slate-400 border">Asset Name</th>
              <th className="px-2 py-1 border-slate-400 border">Average</th>
              <th className="px-2 py-1 border-slate-400 border">Quantity</th>
              <th className="px-2 py-1 border-slate-400 border">Holding</th>
            </tr>
            <tr>
              <td className="px-3 py-3 border-slate-600 border">1</td>
              <td className="px-2 py-3 border-slate-600 border">Ticker</td>
              <td className="px-2 py-3 border-slate-600 border">
                Asset Name asdasdasdasdsads
              </td>
              <td className="px-2 py-3 border-slate-600 border">450</td>
              <td className="px-2 py-3 border-slate-600 border">450</td>
              <td className="px-2 py-3 border-slate-600 border">450</td>
            </tr>
            <tr>
              <td className="px-3 py-3 border-slate-600 border">1</td>
              <td className="px-2 py-3 border-slate-600 border">Ticker</td>
              <td className="px-2 py-3 border-slate-600 border">
                Asset Name asdasdasdasdsads
              </td>
              <td className="px-2 py-3 border-slate-600 border">450</td>
              <td className="px-2 py-3 border-slate-600 border">450</td>
              <td className="px-2 py-3 border-slate-600 border">450</td>
            </tr>
            <tr>
              <td className="px-3 py-3 border-slate-600 border">1</td>
              <td className="px-2 py-3 border-slate-600 border">Ticker</td>
              <td className="px-2 py-3 border-slate-600 border">
                Asset Name asdasdasdasdsads
              </td>
              <td className="px-2 py-3 border-slate-600 border">450</td>
              <td className="px-2 py-3 border-slate-600 border">450</td>
              <td className="px-2 py-3 border-slate-600 border">450</td>
            </tr>
            <tr>
              <td className="px-3 py-3 border-slate-600 border">1</td>
              <td className="px-2 py-3 border-slate-600 border">Ticker</td>
              <td className="px-2 py-3 border-slate-600 border">
                Asset Name asdasdasdasdsads
              </td>
              <td className="px-2 py-3 border-slate-600 border">450</td>
              <td className="px-2 py-3 border-slate-600 border">450</td>
              <td className="px-2 py-3 border-slate-600 border">450</td>
            </tr>
            <tr>
              <td className="px-3 py-3 border-slate-600 border">1</td>
              <td className="px-2 py-3 border-slate-600 border">Ticker</td>
              <td className="px-2 py-3 border-slate-600 border">
                Asset Name asdasdasdasdsads
              </td>
              <td className="px-2 py-3 border-slate-600 border">450</td>
              <td className="px-2 py-3 border-slate-600 border">450</td>
              <td className="px-2 py-3 border-slate-600 border">450</td>
            </tr>
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
