import React, { Component } from "react";
import { Navigate } from "react-router-dom";
import LoginClient from "../Client/LoginClient";
import Button3 from "../util/buttons/Button3";
import Card from "../util/Card/Card";
import GaugeCharts from "../util/charts/GaugeCharts";
import Piechart from "../util/charts/Piechart";
import PortfolioTable from "../util/Table/PortfolioTable";
import TransactionTable from "../util/Table/TransactionTable";

export default class Home extends Component {
  state = {
    user: null,
  };
  componentDidMount() {
    LoginClient.validate().then((user) => this.setState({ user: user }));
  }
  logout = () => {
    localStorage.removeItem("token");
    this.setState({ user: false });
  };
  render() {
    if (
      localStorage.getItem("token") === undefined ||
      this.state.user === false
    ) {
      return <Navigate to="/login" replace />;
    }
    if (this.state.user == null) return <div>loading</div>;
    return (
      <div>
        <div className="border-b border-slate-400 flex flex-wrap justify-between">
          <h1 className="font-serif text-left font-semibold text-xl p-5">
            The Boring Investment Club.
          </h1>
          <Button3
            onpress={this.logout}
            className="border mx-5 m-3 h-10 pt-2 p-6"
          >
            Log Out
          </Button3>
        </div>
        <div className="flex flex-wrap">
          <div className="md:w-2/4 w-full xl:w-1/4">
            <Card title={"Invested"}>
              <div className="text-center text-4xl py-10 h-40">50,00,000₹</div>
            </Card>
          </div>
          <div className="md:w-2/4 w-full xl:w-1/4">
            <Card title={"Holding"}>
              <div className="text-center text-4xl py-10 h-40">
                100,00,000₹
                <span className="text-green-400 text-xl">+50%</span>
                <div className="w-full text-center">
                  <div className="text-green-400 text-xl">
                    +5,00,0000₹ <span className="text-sm"> 22% P.A.</span>
                  </div>
                </div>
              </div>
            </Card>
          </div>
          <div className="md:w-2/4 w-full xl:w-1/4">
            <Card title={"Price To Earning"}>
              <GaugeCharts start={0} end={60} value={41} unit={"P/E"} />
            </Card>
          </div>
          <div className="md:w-2/4 w-full xl:w-1/4">
            <Card title={"Return on Equity"}>
              <GaugeCharts start={0} end={50} value={28} unit={"%"} />
            </Card>
          </div>
          <div className="w-full lg:w-1/3 md:w-1/2">
            <Card title={"Holding"}>
              <div className="h-96">
                <Piechart />
              </div>
            </Card>
          </div>
          <div className="w-full lg:w-auto md:w-1/2">
            <Card title={"Portfolio"}>
              <div className="md:h-96 h-auto">
                <PortfolioTable />
              </div>
            </Card>
          </div>
          <div className="w-full md:w-auto">
            <Card title={"Transaction History"}>
              <div className="md:h-96 h-auto">
                <TransactionTable />
              </div>
            </Card>
          </div>
        </div>
      </div>
    );
  }
}
