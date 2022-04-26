import React from "react";
import {Link} from "react-router-dom";

const books = (props) => {
    return(
        <div className={"container mm-4 mt-5"}>
            <div className={"row"}>
                <div className={"row"}>
                    <table className={"table table-striped"}>
                        <thead>
                            <tr>
                                <th scope={"col"}>Name</th>
                                <th scope={"col"}>Category</th>
                                <th scope={"col"}>Author</th>
                                <th scope={"col"}>Copies</th>
                            </tr>
                        </thead>
                        <tbody>
                            {props.books.map((term)=>{
                                return(
                                    <tr>
                                        <td>{term.name}</td>
                                        <td>{term.category}</td>
                                        <td>{term.author.name} {term.author.surname}</td>
                                        <td>{term.availableCopies}</td>
                                        
                                        <td scope="col" className="text-right">
                                            <a className="btn btn-danger" title="Delete" 
                                            onClick={() => props.onDelete(term.id)}>Delete</a></td>
                                        
                                        
                                        
                                        <td scope="col" className="text-right">
                                            <a className="btn btn-warning" title="Edit" 
                                            onClick={() => props.onEdit(term.id)}
                                            >Edit</a></td>
                                        <td scope="col" className="text-right">
                                            <a className="btn btn-success" title="Mark As Taken" 
                                            onClick={() => props.onMarkAsTaken(term.id)}
                                            >Mark As Taken</a></td>
                                    </tr>
                                );
                            })}
                        </tbody>
                    </table>
                </div>
                <div className="col mb-3">
                    <div className="row">
                        <div className="col-sm-12 col-md-12">
                            <Link className="btn btn-block btn-dark" to="/books/add">Add a new book</Link>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default books