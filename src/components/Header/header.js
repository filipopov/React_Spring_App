import React from "react";
import {Link} from "react-router-dom"

const header = (props) => {
    return(
        <nav className="navbar navbar-expand-lg navbar-light bg-light fixed-top">
            <div className="container">
                <a className="navbar-brand" href="#">Lab 2 EMT</a>
                <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse" id="navbarResponsive">
                    <ul className="navbar-nav ms-auto">
                        <li className="nav-item active">
                            <Link className="nav-link" to="/">Home</Link>
                        </li>
                        <li className="nav-item">
                            <Link className="nav-link" to="books">Books</Link>
                        </li>
                        <li className="nav-item">
                            <Link className="nav-link" to="authors">Authors</Link>
                        </li>
                        <li className="nav-item">
                            <Link className="nav-link" to="categories">Categories</Link>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    );
}

export default header