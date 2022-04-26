import '/Users/filippopov/Documents/CODE/ReactProjects/Lab2EMT-frontend/lab2emt_frontend/src/components/App/App.css';
import React, {Component} from 'react';
import {BrowserRouter as Router, Navigate, Route, Routes} from "react-router-dom"
import Books from "../Books/Books"
import Categories from "../Categories/categories"
import Authors from '../Authors/authors';
import booksService from "/Users/filippopov/Documents/CODE/ReactProjects/Lab2EMT-frontend/lab2emt_frontend/src/repository/booksRepository.js"
import Header from "../Header/header"
import BooksAdd from "../Books/BooksAdd/BooksAdd"


class App extends Component{
    constructor(props){
      super(props)
      this.state = {
        books: [],
        authors: [],
        categories: [],
        selectedBook: {}
      }
    }

    render(){
      return(
        <Router>
          <Header/>
          <br/><br/><br/>
          <Routes>
            <Route path="/books/add" element={<BooksAdd categories={this.state.categories} authors={this.state.authors} onAddBook={this.addBook}/>}/>

            {/* <Route path="/books/edit:id" element={<BooksAdd categories={this.state.categories} authors={this.state.authors} onAddBook={this.addBook}/>}/> */}

            <Route path='/books' element={<Books books={this.state.books} onDelete={this.deleteBook} onMarkAsTaken={this.takeBook}/>}/>
            <Route path='/authors' element={<Authors authors={this.state.authors}/>}/>
            <Route path='/categories' element={<Categories categories={this.state.categories}/>}/>
            <Route path='/' element={<Books books={this.state.books} onDelete={this.deleteBook} onMarkAsTaken={this.takeBook}/>}/>
          </Routes>
        </Router>
      );
    }

    loadBooks = () => {
      booksService.fetchBooks().then((data)=>{
        this.setState({
          books: data.data
        })
      });
    }

    loadAuthors = () => {
      booksService.fetchAuthors().then((data)=>{
        this.setState({
          authors: data.data
        })
      });
    }

    loadCategories = () => {
      booksService.fetchCategories().then((data)=>{
        this.setState({
          categories: data.data
        })
      })
    }

    deleteBook = (id) => {
      booksService.deleteBook(id).then(()=>{
        this.loadBooks();
      })
    }

    componentDidMount(){
      this.loadBooks();
      this.loadAuthors();
      this.loadCategories();
    }

    addBook = (name, category, author, availableCopies) => {
        booksService.addBook(name, category, author, availableCopies).then(()=>{this.loadBooks();})
    }

    takeBook = (id) =>{
      booksService.getBook(id).then((data)=>{
        this.setState({
          selectedBook: data.data
        })
      })
    }

}

export default App;
