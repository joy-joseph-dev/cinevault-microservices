import { useState,useEffect} from "react";
function ShowsPage({movieId,onSelectShow}){
    const[shows, setShows]= useState([]);
     useEffect(()=>{
        fetchShows();
     },[]);
     async function fetchShows(){
        try{
        const response  = await fetch("http://localhost:8080/show-service/shows/1");
        const data = await response.json();
        setShows([data]);
        console.log(data);
       
        }
        catch(error){
            console.log(error);
        }
     }
     return (
        <div>
            <h1 id="showid">Shows</h1>
           <div className="showCard">
            {shows.map(show=>(
            <div key={show.id}>
               <span className=""></span> <p> Date : {show.showDate}</p>
                <p>Time : {show.showTime}</p>
                <p>Base Price : {show.basePrice}</p>
                <button className="buttonClass" onClick={()=>
                    onSelectShow(show.id)}>
                Select Seats</button>
            </div>
            ))}
            </div>
             </div>
           
     );
  
}
export default ShowsPage;
