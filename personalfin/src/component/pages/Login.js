import React, { Component } from "react";
import Button3 from "../util/buttons/Button3";
import { Navigate } from "react-router-dom";
import LoginClient from "../Client/LoginClient";
export default class Login extends Component {
  state = {
    user: false,
    login: "",
    password: "",
  };
  setLogin = (event) => {
    this.setState({ login: event.target.value });
  };
  setPassword = (event) => {
    this.setState({ password: event.target.value });
  };
  login = () => {
    LoginClient.login(this.state.login, this.state.password).then((token) => {
      localStorage.setItem("token", token);
      this.setState({ user: true });
    });
  };
  inviteonly = () => {};
  render() {
    if (this.state.user === true) {
      return <Navigate to="/" replace />;
    }
    return (
      <div>
        <h1 className="font-serif text-center font-semibold text-4xl p-5">
          The Boring Investment Club.
        </h1>
        <div className="flex flex-wrap justify-center pt-5">
          <div className="border-slate-300 border-2 rounded-md md:w-2/4 xl:w-1/3">
            <h1 className="text-center text-2xl font-sans font-semibold pt-5">
              Please Login.
            </h1>
            <div className="w-full flex flex-wrap justify-center">
              <table className="md:m-5 text-lg">
                <tbody>
                  <tr className="py-3">
                    <td className="text-right p-3 sm:p-5">
                      <label className="">Email : </label>
                    </td>
                    <td className="p-3 sm:p-5">
                      <input
                        className="bg-black focus:outline-none border w-full "
                        value={this.state.login}
                        onChange={this.setLogin}
                        type="email"
                      />
                    </td>
                  </tr>
                  <tr className="py-3">
                    <td className="text-right p-3 sm:p-5">
                      <label className="">Password :</label>
                    </td>
                    <td className="p-3 sm:p-5">
                      <input
                        className="bg-black focus:outline-none border w-full"
                        value={this.state.password}
                        onChange={this.setPassword}
                        type="password"
                      />
                    </td>
                  </tr>
                </tbody>
              </table>
            </div>
            <div className="flex flex-wrap justify-center m-5">
              <Button3
                className="border mx-5 mb-3 h-12 pt-3 p-6"
                onpress={this.login}
              >
                Log in
              </Button3>
              <Button3
                className="border mx-5 mb-3 h-12 pt-3 p-6"
                onpress={this.inviteonly}
              >
                Invite Only
              </Button3>
            </div>
          </div>
        </div>
      </div>
    );
  }
}
