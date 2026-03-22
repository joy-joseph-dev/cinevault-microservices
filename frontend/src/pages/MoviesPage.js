import React from "react";
import { useState,useEffect } from "react";

function MoviesPage({onSelectMovie}){
    const[movies, setMovies]= useState([]);
    useEffect(()=>{
        fetchMovies();
     },[]);

    async function fetchMovies(){
        try{
            const response = await fetch("http://localhost:8080/movie-service/movies")
            const data = await response.json();
            setMovies(data);
            console.log(data);
      }
        catch(error){
            console.log(error);
        }

    } 
    return (
        <div>
            <h1 id="h1id">Movies</h1><br></br>
            <div className="movies-container">
            {movies.map(movie=>(
                <span className="movie-card" key={movie.id}>
               <img 
                src={movie.imageUrl}
                alt={movie.title}
                width="150"/>
                <h3>{movie.title}</h3>
                  Genre : {movie.genre}<br></br>
                  Duration : {movie.duration}<br></br>
                
                <button id="viewshows" onClick={()=>
                    onSelectMovie(movie.id)}
                   >View Shows</button>
                </span>
            ))}
            </div>
        </div>
    );
}
export default MoviesPage;