import React from "react";
import UserServices from "../services/UserServices";
import {Navbar, Nav, Form, FormControl, Button} from "react-bootstrap";

class UserComponents extends React.Component{
    constructor(props){
        super(props)
        this.state={
            users:[]
        }
    }
    componentDidMount(){
        UserServices.getUsers().then((Response)=>{
            this.setState({users:Response.data})
        });
    }
    render(){
        return(
            <div>
                <Navbar bg="dark" variant="dark">
                        <Nav className="mr-auto">
                            <Nav.Link href="#home">Home</Nav.Link>
                            <Nav.Link href="#features">Features</Nav.Link>
                            <Nav.Link href="#pricing">Pricing</Nav.Link>
                        </Nav>
                        <Form inline>
                            <FormControl type="text" placeholder="Search" className="mr-5" />
                            <Button variant="outline-info">Search</Button>
                        </Form>
                </Navbar>
                <h1 className = "text-center">Users List</h1>
                <table className = "table table-striped">
                    <thead>
                        <tr>
                            <th>User Id</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Username</th>
                        </tr>
                    </thead>

                    <tbody>
                        {
                            this.state.users.map(
                                user =>
                                <tr key = {user.id}>
                                    <td>{user.id}</td>
                                    <td>{user.firstName}</td>
                                    <td>{user.lastName}</td>
                                    <td>{user.username}</td>
                                </tr>
                            )
                            }
                    </tbody>
                </table>
            </div>
        )
    }
}
export default UserComponents