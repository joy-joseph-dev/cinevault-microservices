import { useState } from "react";
import MoviesPage from "./pages/MoviesPage";
import ShowsPage from "./pages/ShowsPage";
import SeatPage from "./pages/SeatPage";
import "./App.css";
function App(){
    const [selectedMovieId,setSelectedMovieId]=useState(null);
    const [selectedShowId,setSelectedShowId]=useState(null);
    return (
        <div>
            {!selectedMovieId && (
            <MoviesPage onSelectMovie={setSelectedMovieId}/>)}
            {selectedMovieId && !selectedShowId && (
            <ShowsPage movieId={selectedMovieId}
            onSelectShow={setSelectedShowId}/>)}
            {selectedShowId&&(<SeatPage showId={selectedShowId}/>)}
        </div>
    );
}
export default App;