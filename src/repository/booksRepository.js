import axios from "../custom-axios/axios";

const BooksService = {
    fetchBooks: () => {
        return axios.get("/books")
    },
    fetchAuthors: () => {
        return axios.get("/authors")
    },
    fetchCategories: () => {
        return axios.get("/categories")
    },
    deleteBook: (id) => {
        return axios.delete("/books/delete/"+id)
    },
    addBook: (name, category, author, availableCopies) => {
        return axios.post("/books/add",{
            "name": name,
            "category": category,
            "author": author,
            "availableCopies": availableCopies
        })
    },
    takeBook: (id) => {
        return axios.post("/books/markAsTaken/"+id)
    },
    getBook: (id) => {
        return axios.get("/books/"+id)
    }
}

export default BooksService