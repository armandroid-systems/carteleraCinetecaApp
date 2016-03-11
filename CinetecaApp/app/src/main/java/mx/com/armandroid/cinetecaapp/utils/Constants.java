package mx.com.armandroid.cinetecaapp.utils;

/**
 * Created by armando.dominguez on 07/03/2016.
 */
public class Constants {

    public static final String KEY_PARAM = "param_key";

    public static final int BIN_FALSE = 0;
    public static final int BIN_TRUE  = 1;

    public static final String VIEW_SUMMARY = "view_list";
    public static final String VIEW_DETAIL = "view_detail";

    public static final String API_ENDPOINT = "http://192.168.100.4:1337/carteleradia/";
    public static final String URL_YOUTUBE = "http://www.youtube.com/watch?v=";
    public static final String API_RESPONSE_FAKE ="{\n" +
            "  \"error\": 200,\n" +
            "  \"peliculas\": [\n" +
            "    {\n" +
            "      \"peliculaTitulo\": \"�Que viva la m�sica!\",\n" +
            "      \"peliculaMiniFicha\": \"(Carlos Moreno, Colombia-M�xico, 2015, 101 mins.)\",\n" +
            "      \"peliculaSinopsis\": \"La película sigue los pasos de la exuberante María del Carmen por la ciudad de Cali, Colombia. Impulsada por la música y el baile que encuentra en el camino, esta chica abandona la...\",\n" +
            "      \"horarios\": \"Jueves 10 de marzo de 2016\\nSALA 4: 15:00\",\n" +
            "      \"urlImg\": \"http://www.cinetecanacional.net/imagenes/img_peliculas/10266-C.jpg\",\n" +
            "      \"urlDetail\": \"php/detallePelicula.php?clv=10266&Tit=�Que viva la m�sica!\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"peliculaTitulo\": \"A los Ojos\",\n" +
            "      \"peliculaMiniFicha\": \"(Michel Franco, M�xico, 2013, 96 mins.)\",\n" +
            "      \"peliculaSinopsis\": \"Mónica, una trabajadora social, debe enfrentar la compleja enfermedad visual de su hijo de once años, quien requiere un urgente trasplante de córnea para evitar la ceguera.  Agobiada...\",\n" +
            "      \"horarios\": \"Jueves 10 de marzo de 2016\\nSALA 7: 15:15, 17:45\",\n" +
            "      \"urlImg\": \"http://www.cinetecanacional.net/imagenes/img_peliculas/14153-C.jpg\",\n" +
            "      \"urlDetail\": \"php/detallePelicula.php?clv=14153&Tit=A los Ojos\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"peliculaTitulo\": \"Alguien como yo\",\n" +
            "      \"peliculaMiniFicha\": \"(Eine wen iig, dr D�llebach Kari, Xavier Koller, Suiza, 2012, 111 mins.)\",\n" +
            "      \"peliculaSinopsis\": \"En una pequeña barbería de la capital suiza, Kari Tellenbach, el dueño del establecimiento, deleita a sus clientes de una forma muy peculiar. El barbero nació con el labio leporino...\",\n" +
            "      \"horarios\": \"Jueves 10 de marzo de 2016\\nSALA 3: 19:30\",\n" +
            "      \"urlImg\": \"http://www.cinetecanacional.net/imagenes/img_peliculas/14185-C.jpg\",\n" +
            "      \"urlDetail\": \"php/detallePelicula.php?clv=14185&Tit=Alguien como yo\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"peliculaTitulo\": \"Ausencia\",\n" +
            "      \"peliculaMiniFicha\": \"(Aus�ncia, Chico Teixeira, Brasil-Chile-Francia, 2014, 87 mins.)\",\n" +
            "      \"peliculaSinopsis\": \"Drama social y familiar que gira en torno a Serginho, un niño obligado a crecer antes de tiempo. Sin una figura paterna que lo respalde, las circunstancias lo han hecho responsable de su madre alcohólica...\",\n" +
            "      \"horarios\": \"Jueves 10 de marzo de 2016\\nSALA 10: 18:30\",\n" +
            "      \"urlImg\": \"http://www.cinetecanacional.net/imagenes/img_peliculas/14174-C.jpg\",\n" +
            "      \"urlDetail\": \"php/detallePelicula.php?clv=14174&Tit=Ausencia\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"peliculaTitulo\": \"Carol\",\n" +
            "      \"peliculaMiniFicha\": \"(Todd Haynes, Reino Unido-Estados Unidos, 2015, 118 mins.)\",\n" +
            "      \"peliculaSinopsis\": \"Esta película ganadora de la Queer Palm y del Premio a Mejor Actriz en el Festival de Cannes, retrata una historia ambientada en los años 50 donde una joven empleada de una tienda, aspirante...\",\n" +
            "      \"horarios\": \"Jueves 10 de marzo de 2016\\nSALA 2: 14:00, 19:00\",\n" +
            "      \"urlImg\": \"http://www.cinetecanacional.net/imagenes/img_peliculas/14132-C.jpg\",\n" +
            "      \"urlDetail\": \"php/detallePelicula.php?clv=14132&Tit=Carol\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"peliculaTitulo\": \"Conversando con Jos� Buil\",\n" +
            "      \"peliculaMiniFicha\": \"(0 mins.)\",\n" +
            "      \"peliculaSinopsis\": \"Este jueves 10 de marzo exhibiremos La línea paterna (1995), el documental retrata la historia de un cineasta que recupera fotos y películas tomadas por su abuelo en Papantla, Veracruz, en...\",\n" +
            "      \"horarios\": \"Jueves 10 de marzo de 2016\\nSALA 4: 18:00\",\n" +
            "      \"urlImg\": \"http://www.cinetecanacional.net/imagenes/img_peliculas/14186-C.jpg\",\n" +
            "      \"urlDetail\": \"php/detallePelicula.php?clv=14186&Tit=Conversando con Jos� Buil\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"peliculaTitulo\": \"Cuerpo de letra\",\n" +
            "      \"peliculaMiniFicha\": \"(Juli�n D�Angiolillo, Argentina, 2015, 77 mins.)\",\n" +
            "      \"peliculaSinopsis\": \"La palabra tiene que leerse desde la distancia veloz de una autopista, el color identificará el nombre pintado en el muro con un partido político. Durante la campaña, toda superficie...\",\n" +
            "      \"horarios\": \"Jueves 10 de marzo de 2016\\nSALA 8: 19:30\",\n" +
            "      \"urlImg\": \"http://www.cinetecanacional.net/imagenes/img_peliculas/14154-C.jpg\",\n" +
            "      \"urlDetail\": \"php/detallePelicula.php?clv=14154&Tit=Cuerpo de letra\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"peliculaTitulo\": \"El abrazo de la serpiente\",\n" +
            "      \"peliculaMiniFicha\": \"(Ciro Guerra, Colombia-Venezuela-Argentina, 2015, 125 mins.)\",\n" +
            "      \"peliculaSinopsis\": \"Karamakate, un poderoso chamán amazónico y último sobreviviente de su  pueblo, vive en asilamiento voluntario en lo más profundo de la selva.  Años de total soledad lo...\",\n" +
            "      \"horarios\": \"Jueves 10 de marzo de 2016\\nSALA 2: 16:30, 21:30\",\n" +
            "      \"urlImg\": \"http://www.cinetecanacional.net/imagenes/img_peliculas/14133-C.jpg\",\n" +
            "      \"urlDetail\": \"php/detallePelicula.php?clv=14133&Tit=El abrazo de la serpiente\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"peliculaTitulo\": \"El Maestro y Divino\",\n" +
            "      \"peliculaMiniFicha\": \"(O Mestre e o Divino, Tiago Campos Torres, Brasil, 2013, 85 mins.)\",\n" +
            "      \"peliculaSinopsis\": \"Dos cineastas retratan la vida en la aldea y la misión de Sangradouro, en el estado de Mato Grosso, Brasil: Adalbert  Heide, un excéntrico misionero alemán que ha filmado a los...\",\n" +
            "      \"horarios\": \"Jueves 10 de marzo de 2016\\nSALA 10: 20:30\",\n" +
            "      \"urlImg\": \"http://www.cinetecanacional.net/imagenes/img_peliculas/14178-C.jpg\",\n" +
            "      \"urlDetail\": \"php/detallePelicula.php?clv=14178&Tit=El Maestro y Divino\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"peliculaTitulo\": \"El ni�o y el mundo\",\n" +
            "      \"peliculaMiniFicha\": \"(O Menino e o Mundo, Al� Abreu, Brasil, 2013, 80 mins.)\",\n" +
            "      \"peliculaSinopsis\": \"Un niño que sufre por la falta de su padre, quien ha dejado a la familia para irse a trabajar a algún lugar distante, sale de la aldea donde vive para descubrir un mundo fantástico,...\",\n" +
            "      \"horarios\": \"Jueves 10 de marzo de 2016\\nSALA 1: 20:30\",\n" +
            "      \"urlImg\": \"http://www.cinetecanacional.net/imagenes/img_peliculas/13523-C.jpg\",\n" +
            "      \"urlDetail\": \"php/detallePelicula.php?clv=13523&Tit=El ni�o y el mundo\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"peliculaTitulo\": \"En primera plana\",\n" +
            "      \"peliculaMiniFicha\": \"(Spotlight, Tom McCarthy, Estados Unidos, 2015, 128 mins.)\",\n" +
            "      \"peliculaSinopsis\": \"En primera plana narra la fascinante historia real de una investigación llevada a cabo por el Boston Globe, ganadora del Premio Pulitzer. Los resultados sacudieron a la capital de Massachusetts...\",\n" +
            "      \"horarios\": \"Jueves 10 de marzo de 2016\\nSALA 10: 15:30\",\n" +
            "      \"urlImg\": \"http://www.cinetecanacional.net/imagenes/img_peliculas/14070-C.jpg\",\n" +
            "      \"urlDetail\": \"php/detallePelicula.php?clv=14070&Tit=En primera plana\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"peliculaTitulo\": \"Entre Cuba y M�xico, todo es bonito y sabroso\",\n" +
            "      \"peliculaMiniFicha\": \"(Between Cuba and Mexico, everything is bonito & sabroso, Idalmis del Risco Siota, Cuba-M�xico, 2015, 82 mins.)\",\n" +
            "      \"peliculaSinopsis\": \"Recuento de las relaciones de hermandad entre Cuba y México desde el siglo xix. La cercanía geográfica ha propiciado una amistad, simpatía y comunidad que identifican a ambos...\",\n" +
            "      \"horarios\": \"Jueves 10 de marzo de 2016\\nSALA 5: 14:30, 18:30\",\n" +
            "      \"urlImg\": \"http://www.cinetecanacional.net/imagenes/img_peliculas/7211-C.jpg\",\n" +
            "      \"urlDetail\": \"php/detallePelicula.php?clv=7211&Tit=Entre Cuba y M�xico, todo es bonito y sabroso\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"peliculaTitulo\": \"Hide & Seek: A las escondidas\",\n" +
            "      \"peliculaMiniFicha\": \"(Hide and Seek, Joanna Coates, Reino Unido-Estados Unidos, 2014, 82 mins.)\",\n" +
            "      \"peliculaSinopsis\": \"Leah, Max, Charlotte y Jack están cansados de sus respectivas vidas en Londres y de las relaciones que tienen, por lo que toman una drástica decisión: se mudan a una enorme casa en...\",\n" +
            "      \"horarios\": \"Jueves 10 de marzo de 2016\\nSALA 6: 15:15\",\n" +
            "      \"urlImg\": \"http://www.cinetecanacional.net/imagenes/img_peliculas/14077-C.jpg\",\n" +
            "      \"urlDetail\": \"php/detallePelicula.php?clv=14077&Tit=Hide & Seek: A las escondidas\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"peliculaTitulo\": \"La paz\",\n" +
            "      \"peliculaMiniFicha\": \"(Santiago Loza, Argentina, 2013, 73 mins.)\",\n" +
            "      \"peliculaSinopsis\": \"Liso, un joven de clase media alta que ha estado internado en un hospital psiquiátrico, sale para reencontrarse con su familia, pero la situación no es nada fácil.  Con una madre...\",\n" +
            "      \"horarios\": \"Jueves 10 de marzo de 2016\\nSALA 5: 16:30, 20:30\",\n" +
            "      \"urlImg\": \"http://www.cinetecanacional.net/imagenes/img_peliculas/12865-C.jpg\",\n" +
            "      \"urlDetail\": \"php/detallePelicula.php?clv=12865&Tit=La paz\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"peliculaTitulo\": \"Malgr� tout\",\n" +
            "      \"peliculaMiniFicha\": \"(Jorge Prior, M�xico, 2014, 68 mins.)\",\n" +
            "      \"peliculaSinopsis\": \"Documental sobre el artista plástico mexicano Jesús Contreras, quien fue uno de los escultores más reconocidos durante el porfiriato y creador de Malgré tout, mítica...\",\n" +
            "      \"horarios\": \"Jueves 10 de marzo de 2016\\nSALA 9: 19:00\",\n" +
            "      \"urlImg\": \"http://www.cinetecanacional.net/imagenes/img_peliculas/14155-C.jpg\",\n" +
            "      \"urlDetail\": \"php/detallePelicula.php?clv=14155&Tit=Malgr� tout\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"peliculaTitulo\": \"Mustang: belleza salvaje\",\n" +
            "      \"peliculaMiniFicha\": \"(Mustang, Deniz Gamze Erg�ven, Turqu�a-Francia-Alemania-Qatar, 2015, 97 mins.)\",\n" +
            "      \"peliculaSinopsis\": \"El comienzo del verano. En un pueblo en el norte de Turquía, Lale y sus cuatro hermanas están caminando a casa desde la escuela, jugando inocentemente con algunos chicos. La supuesta inmoralidad...\",\n" +
            "      \"horarios\": \"Jueves 10 de marzo de 2016\\nSALA 9: 14:00, 16:30, 21:00\",\n" +
            "      \"urlImg\": \"http://www.cinetecanacional.net/imagenes/img_peliculas/13932-C.jpg\",\n" +
            "      \"urlDetail\": \"php/detallePelicula.php?clv=13932&Tit=Mustang: belleza salvaje\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"peliculaTitulo\": \"Revenant: El renacido\",\n" +
            "      \"peliculaMiniFicha\": \"(The Revenant, Alejandro Gonz�lez I��rritu, Estados Unidos, 2015, 156 mins.)\",\n" +
            "      \"peliculaSinopsis\": \"Fascinante historia de supervivencia y venganza ambientada en el salvaje medio oeste de los Estados Unidos en la década de 1820, El renacido de Alejandro González Iñárritu está...\",\n" +
            "      \"horarios\": \"Jueves 10 de marzo de 2016\\nSALA 1: 14:30, 17:30\",\n" +
            "      \"urlImg\": \"http://www.cinetecanacional.net/imagenes/img_peliculas/14069-C.jpg\",\n" +
            "      \"urlDetail\": \"php/detallePelicula.php?clv=14069&Tit=Revenant: El renacido\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"peliculaTitulo\": \"Seguir viviendo\",\n" +
            "      \"peliculaMiniFicha\": \"(Alejandra S�nchez, M�xico, 2014, 81 mins.)\",\n" +
            "      \"peliculaSinopsis\": \"Dos niños que huyen de Ciudad Juárez amenazados de muerte y una periodista que perdió a su hijo en un accidente automovilístico se encuentran y se relacionan íntimamente....\",\n" +
            "      \"horarios\": \"Jueves 10 de marzo de 2016\\nSALA 8: 17:00, 21:15\",\n" +
            "      \"urlImg\": \"http://www.cinetecanacional.net/imagenes/img_peliculas/12806-C.jpg\",\n" +
            "      \"urlDetail\": \"php/detallePelicula.php?clv=12806&Tit=Seguir viviendo\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"peliculaTitulo\": \"Viaje a Italia\",\n" +
            "      \"peliculaMiniFicha\": \"(Viaggio in Italia, Roberto Rossellini, Francia-Italia, 1953, 86 mins.)\",\n" +
            "      \"peliculaSinopsis\": \"Un matrimonio viaja a Nápoles. En el trayecto, ambos se percatan de cuán ajenos son el uno hacia el otro, iniciando así una espiral de desamor. Más que retratar el crepúsculo...\",\n" +
            "      \"horarios\": \"Jueves 10 de marzo de 2016\\nSALA 7: 20:00\",\n" +
            "      \"urlImg\": \"http://www.cinetecanacional.net/imagenes/img_peliculas/13446-C.jpg\",\n" +
            "      \"urlDetail\": \"php/detallePelicula.php?clv=13446&Tit=Viaje a Italia\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";
}
