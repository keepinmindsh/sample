import React from 'react';
import './App.css';
import './vendor/bootstrap/css/bootstrap.min.css';
import './vendor/fontawesome-free/css/all.min.css';
import './vendor/datatables/dataTables.bootstrap4.css';
import './styles/sb-admin.css';

function App() {

  let stringValue : string = 'value';

  return (
<>
    <nav className="navbar navbar-expand navbar-dark bg-dark static-top">
      <a className="navbar-brand mr-1" href="index.html">Sample Wiki</a>
      <button className="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" >
        <i className="fas fa-bars"></i>
      </button>
    </nav>

    <div id="wrapper">
      <ul className="sidebar navbar-nav">
        <li className="nav-item active">
          <a className="nav-link" href="index.html">
            <i className="fas fa-fw fa-tachometer-alt"></i>
            <span>{"Dashboard"}</span>
          </a>
        </li>       
      </ul>

      <div id="content-wrapper">
          <div className="container-fluid">

            <ol className="breadcrumb">
              <li className="breadcrumb-item">
                <a href="#">{"Dashboard"}</a>
              </li>
              <li className="breadcrumb-item active">{"Overview"}</li>
            </ol>

            <div className="card mb-3">
              <div className="card-header">
                {"Sample Information"}
              </div>
              <div className="card-body">
                
              </div>
            </div>
          </div>
          <footer className="sticky-footer">
            <div className="container my-auto">
              <div className="copyright text-center my-auto">
                <span>{"Copyright © Your Website 2020"}</span>
              </div>
            </div>
          </footer>
        </div>
    </div>
</>

    
  );
}

export default App;
