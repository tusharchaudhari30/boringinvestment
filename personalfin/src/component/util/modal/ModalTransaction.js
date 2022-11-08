import React, { Component } from "react";

export default class ModalTransaction extends Component {
  render() {
    return (
      <React.Fragment>
        <div
          className="min-h-screen fixed bg- bg-black w-full z-10 opacity-60"
          style={{ left: 0, right: 0, top: 0 }}
        ></div>
        <div
          className="lg:w-6/12 w-full bg-black fixed opacity-100 border border-gray-500 z-20"
          style={{ left: "25%", top: "25%" }}
        >
          <div
            className="w-full border-b text-xl flex flex-wrap justify-between border-gray-500"
            onClick={this.props.changeTransactionVisible}
          >
            <span className="py-3 px-5 text-gray-300">Transaction</span>{" "}
            <div className="border-l py-3 px-5 hover:bg-white hover:text-black hover:cursor-pointer border-gray-500">
              X
            </div>
          </div>
          <div className="w-full text-gray-300">
            <div className="w-full flex justify-center">
              <table className="text-lg">
                <tbody>
                  <tr className="py-3">
                    <td className="text-right p-3 pt-6">
                      <label className="">Asset Name : </label>
                    </td>
                    <td className="p-3 pt-6">
                      <input
                        className="bg-black focus:outline-none border w-full p-1 text-sm border-gray-300"
                        type="text"
                      />
                    </td>
                  </tr>
                  <tr className="py-3">
                    <td className="text-right p-3">
                      <label className="">Amount :</label>
                    </td>
                    <td className="p-3">
                      <input
                        className="bg-black focus:outline-none border w-full text-sm p-1 border-gray-300"
                        type="number"
                      />
                    </td>
                  </tr>
                  <tr className="py-3">
                    <td className="text-right p-3">
                      <label className="">Average :</label>
                    </td>
                    <td className="p-3">
                      <input
                        className="bg-black focus:outline-none border w-full text-sm p-1 border-gray-300"
                        type="number"
                      />
                    </td>
                  </tr>
                  <tr className="py-3">
                    <td className="text-right p-3">
                      <label className="">Date :</label>
                    </td>
                    <td className="p-3">
                      <input
                        className="bg-black focus:outline-none border w-full text-sm p-1 border-gray-300"
                        type="date"
                      />
                    </td>
                  </tr>
                </tbody>
              </table>
            </div>
            <div className="flex flex-wrap justify-center py-3 pb-6">
              <button className="focus:outline-none px-6 py-3 border border-slate-300 hover:bg-slate-200 hover:text-black">
                Save
              </button>
            </div>
          </div>
        </div>
      </React.Fragment>
    );
  }
}
