package antynews.controller;

import antynews.model.Article;
import antynews.model.Category;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@WebServlet(name = "Source Page",value = "/antynews/main")
public class SourcePageController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        ArticleRepository articleRepository = ArticleRepository.getInstance();


        List<Article> articles = articleRepository.getAllArticles()
                .stream()
                .sorted(Comparator.comparing(Article::getDate).reversed())
                .collect(Collectors.toList());


        req.setAttribute("articles", articles.toArray());
// Uncomment to add values to Database
//        Date date1 = Article.parseDate("2018-06-08");
//        Date date2 = Article.parseDate("2018-05-12");
//        Date date3 = Article.parseDate("2018-04-27");
//        Date date4 = Article.parseDate("2018-03-02");
//        Date date5 = Article.parseDate("2018-02-18");
//
//
//
//        Category security = new Category("Security");
//        Category music = new Category("Muzyka");
//        Category podroze = new Category("Podróże");
//        Category miasta = new Category("Miasta");
//        Category konsole = new Category("Konsole");
//
//        String rodo = "../public/img/rodo.jpg";
//        String metallica = "../public/img/metallica.jpg";
//        String wroclaw = "../public/img/wroclaw.jpg";
//        String hawaje = "../public/img/hawaje.jpg";
//        String play = "../public/img/playstation.jpg";
//
//
//
//        Article article1 = new Article("RODO: bezpieczeństwo urządzeń mobilnych jest niezbędne", "Chociaż strategia „Bring Your Own Device” (BYOD) jest znana od lat i z racji optymalizacji kosztów oficjalnie akceptowana w wielu firmach, to jej wdrożenie nie należy do najłatwiejszych — przede wszystkim ze względów bezpieczeństwa. Wiele osób zdaje sobie sprawę z ryzyka, jakie niesie wykorzystywanie prywatnych urządzeń w środowisku biznesowym, zwłaszcza teraz, gdy działy IT przedsiębiorstw muszą brać pod uwagę wymogi związane z rozporządzeniem o ochronie danych osobowych (RODO), które od kilkunastu dni obowiązuje w Polsce. Przyjrzyjmy się na co zwrócić uwagę, aby prywatne urządzenia pracowników nie wykorzystywane w ramach BYOD nie stanowiły zagrożenia dla firmowych danych. \u2028\n" +
//                "\n" +
//                "\n" +
//                "\n" +
//                "Wielu pracowników próbuje podpinać prywatny sprzęt do firmowej sieci Wi-Fi\n" +
//                "Mimo tego, że coraz większe znaczenie zyskują takie hasła jak „Corporate owned, business only” (COBO) czy „Corporate owned, personally enabled” (COPE), to wykorzystywanie różnych “nieautoryzowanych” do użycia w firmie urządzeń w ramach codziennych obowiązków jest niemożliwe do powstrzymania. Pracownicy często rozmawiają między sobą, a nawet wymieniają się firmowymi plikami, przez prywatne konta w popularnych komunikatorach np. WhatsApp czy Signal. Choć komunikatory te szyfrują korespondencję, to wymieniane przez nie informacje często zostają na urządzeniu pracownika. Nawet kiedy odejdzie on z firmy.\n" +
//                "\n" +
//                "Dlatego każda firma powinna opracować silne koncepcje bezpieczeństwa w zakresie mobilnych urządzeń końcowych, nie tylko ze względu na zmiany wymuszone przez RODO, ale przede wszystkim jako jeden z elementów ochrony przed typowymi atakami cyberprzestępców. Tu pomocnym narzędziem będzie system klasy EMM (Enterprise Mobility Management), czyli rozwiązanie do zarządzania urządzeniami mobilnymi w przedsiębiorstwie, które pozwala w jednym miejscu monitorować przepływ firmowych danych przez urządzenia jak i nakładać adekwatne restrykcje na działania poszczególnych użytkowników lub urządzeń. Systemy EMM pozwalają na masowe zarządzanie firmowym sprzętem w zależności od lokalizacji, potrzebnego dostępu do danych, czy stanowiska. Przyjrzyjmy się 3 możliwym elementom EMM:\n" +
//                "\n" +
//                "System MDM: zarządzanie urządzeniami mobilnymi: Dzięki MDM administrator ma możliwość wymuszania różnych ustawień na urządzeniach niezależnie od wykorzystywanego na nich systemu operacyjnego: parametry, takie jak nazwisko, domena i serwer, wprowadzane są za pośrednictwem jednolitej maski. Na urządzenia można “wypchnąć” dane dostępowe do połączenia z siecią VPN, Wi-Fi czy zdalnie skonfigurować skrzynkę pocztową użytkownikowi. Administrator może wymusić na urządzeni odpowiedni, adekwatny do stanowiska czy wymogów projektowych, poziom bezpieczeństwa, kontrolując m.in. reguły dotyczące stopnia złożoności hasła lub automatycznej blokady w przypadku zdefiniowanego czasu braku aktywności użytkownika. Do najważniejszych funkcji MDM należy również automatyczne sprawdzanie zgodności i niezwłoczne zgłaszanie ewentualnych naruszeń, takich jak na przykład ingerencja w oprogramowanie firmowe. MDM-em można objąć zarówno firmowy jak i prywatny sprzęt — tzw. enrolment, czyli podpięcie urządzenia pod serwer MDM, który przejmuje na nim kontrolę, można zrealizować w trybie automatycznym lub samodzielnym, a w zależności od lokalizacji urządzenia może znaleźć się na nim zestaw innych ograniczeń.\n" +
//                "System MAM: zarządzanie aplikacjami mobilnymi: Za pomocą rozwiązania do zarządzania aplikacjami mobilnymi administratorzy określają, które aplikacje mogą być wykorzystywane przez pracowników. Koniec ze Slackiem na firmowym sprzęcie! Odbywa się to za pośrednictwem tak zwanej „czarnej” i „białej” listy aplikacji zakazanych i dozwolonych. W zależności od profilu użytkownika i wytycznych dotyczących zgodności, listy te przesyłane są na urządzenie, stanowiąc tym samym skuteczną ochronę przed potencjalnie niebezpiecznymi lub niepożądanymi aplikacjami – na przykład takimi, które wymagają zbyt kompleksowego dostępu do danych lub nie wspierają wymaganych prawem technik ochrony danych (np. nie korzystają w ogóle z algorytmów szyfrowania albo stosowana przez nich ochrona kryptograficzna jest zbyt słaba).\n" +
//                "System MCM – zarządzanie zawartością mobilną: MCM określa zasady dotyczące przesyłania treści za pomocą urządzeń mobilnych oraz obsługi systemów zarządzania dokumentami, np. listą kontaktów, kalendarzem, notatkami oraz wiadomościami e-mail, które należy całkowicie odizolować od innych danych. Wszystkie dane krytyczne przedsiębiorstwa znajdujące się w jednej aplikacji mogą być są chronione przed interakcją z “prywatnymi” aplikacjami użytkownika lub po prostu przed złośliwym oprogramowaniem, którym zainfekowane może zostać urządzenie — w końcu na prywatnym sprzęcie dalej to użytkownik może wykonywać wiele potencjalnie groźnych akcji. W celu zwiększenia bezpieczeństwa, dane znajdujące się w aplikacji odizolowanej są szyfrowane. W przypadku utraty urządzenia, administratorzy mogą zdalnie usunąć zawarte w nim treści.\n" +
//                "UEM, czyli jeden system, w którym jest wszystko\n" +
//
//                "Odpowiedzialność: Przedsiębiorstwo musi być w stanie wykazać zgodność z wymogami RODO, a każde naruszenie przepisów w zakresie ochrony danych (np. utrata końcowego urządzenia mobilnego) musi zostać niezwłocznie zgłoszone właściwej jednostce. Ponieważ niezastosowanie się do przepisów może podlegać karze pieniężnej, powinno się opracować wewnątrzfirmowe reguły, które będą jasne i zrozumiałe dla każdego pracownika.", date1, security, rodo);
//        Article article2 = new Article("Więcej mocy dla Playstation 4!", "Niezwykła premiera: po raz pierwszy w historii firmy w ramach tej samej serii PlayStation Sony wypuszcza na rynek wersję odświeżoną nie tylko wizualnie, ale przede wszystkim technicznie. Co takiego specjalnego ma w sobie PlayStation Pro za 1769 złotych, że Sony zrywa ze swoją tradycją?\n" +
//                "\n" +
//                "REKLAMA\n" +
//                "\n" +
//                "REKLAMA\n" +
//                "\n" +
//                "30 gier na początek\n" +
//                "Naturalnie Sony obiecuje przede wszystkim wzrost szybkości, więcej mocy i ostrzejszy obraz. Wersja Pro ma wyświetlać wybrane gry maksymalnie w 60 klatkach na sekundę, a więc zdecydowanie płynniej, a oprócz tego w większej ostrości: na ekranie telewizora 4K ma to być 4096 x 2160 pikseli.\n" +
//                "\n" +
//                "Jak na razie firma Sony za pomocą patchy przystosowała do wyświetlania w większej ostrości 30 gier. Ale na rozdzielczości 4K skorzystają także filmy i seriale z takich serwisów, jak Netflix albo YouTube. Jednak filmy z płyty na PS4 Pro wyświetlimy póki co w maksymalnej rozdzielczości Full HD, ponieważ nowa konsola nie ma napędu Blu-ray UHD. Zagadką pozostaje, dlaczego akurat tutaj doszło do cięcia kosztów. Szkoda, bo fani filmów wciąż potrzebują dodatkowego odtwarzacza do wyświetlania filmów w doskonałej ostrości. Kiepską pociechą jest fakt, że PS4 Pro w przeciwieństwie do edycji Slim znów ma złącze optyczne i dodatkowe gniazdo USB.\n" +
//                "\n" +
//                "Ue65ks9505xxe\n" +
//                "\n" +
//                "Wiele szczegółów, więcej kontrastu\n" +
//                "Światy gier w Call of Duty, Titanfall 2 i tym podobnych na telewizorze 4K faktycznie wyglądają o wiele bardziej szczegółowo, a cyfrowa rzeczywistość dzięki technologii HDR prezentuje się soczyściej i ma piękniejsze, bardziej kontrastowe kolory. High Dynamic Range zapewnia też lepszy rozkład jasności. Ale komu tak naprawdę opłaci się zmienić konsolę? Jak duża jest różnica w stosunku do standardowej PS4?\n" +
//                "\n" +
//                "INWESTYCJA W TELEWIZOR 4K WRESZCIE ZACZYNA SIĘ ZWRACAĆ RÓWNIEŻ W GRACH - PS4 PRO JUŻ JEST NA MOJEJ LIŚCIE ZAKUPÓW!\n" +
//                "\n" +
//                "TomekTomasz Paczuski, redaktor\n" +
//                "\n" +
//                "Tylko do salonu high-tech\n" +
//                "W pierwszym teście praktycznym Komputer Świata PS4 Pro pokazała swoje mocne strony. Z żywymi kolorami i wysoką rozdzielczością aktualne hitowe tytuły jak Call of Duty - Infinite Warfare wywołują efekt opadnięcia szczęki.\n" +
//                "\n" +
//                "Kto chce skorzystać z tych dobrodziejstw, musi kupić telewizor 4K. Jeśli takiego nie mamy, w najnowszym wydaniu Komputer Świat Special od strony 60 dowiemy się, na co zwracać uwagę przy wyborze telewizora i jaki model aktualnie najlepiej kupić z liczbą pikseli czterokrotnie większą w stosunku do TV z matrycą Full HD.\n" +
//                "\n" +
//                "Wciąż zmieści się w regale: chociaż PS4 Pro w porównaniu ze Slim ma znacznie większą wysokość, to jej szerokość wzrosła tylko minimalnie: Slim i oryginalna PS4 mają około 27 cm, a Pro prawie 30 cm. Jednak konsola 4K znacznie więcej waży - 3,2 kg to ponad kilogram więcej niż PS4 Slim. Nawet oryginalna PS4 była lżejsza. Xbox One z wagą 4,5 kg pozostaje tu niedościgniony.\n" +
//                "\n" +
//                "Właściwie sprawa jest prosta: gracze, którzy nie mają jeszcze PlayStation 4, ale posiadają już telewizor 4K lub chcą go kupić w najbliższym czasie, powinni zafundować sobie nową PS4 Pro. Kosztuje mniej więcej 250 złotych więcej niż PS4, ale punktuje rozdzielczością 4K i technologią HDR. Kto natomiast ma już PS4, może zrezygnować z zakupu. 30 gier zoptymalizowanych dla PS4 Pro ma wprawdzie lepszą ostrość i płynność, ale nie jest to jakiś wielki skok jakościowy. Do gamingu 4K bez żadnych kompromisów przyrost mocy i tak jest niewystarczający. Pomimo to 1769 złotych to niewygórowana cena za nową konsolę.", date2, konsole, play);
//        Article article3 = new Article("Wrocław z tytułem European Best Destination 2018!", "Wrocław zwyciężył w międzynarodowym konkursie European Best Destination 2018. Stolica Dolnego Śląska zdobyła ponad 41 tysięcy głosów. Dzięki zaangażowaniu wrocławian, lokalnych środowisk oraz gości z Polski i całego świata możemy pochwalić się tytułem najlepszej europejskiej destynacji turystycznej.\n" +
//                "\n" +
//                "Wrocław zwyciężył w międzynarodowym konkursie European Best Destination 2018. Stolica Dolnego Śląska zdobyła ponad 41 tysięcy głosów. Dzięki zaangażowaniu wrocławian, lokalnych środowisk oraz gości z Polski i całego świata możemy pochwalić się tytułem najlepszej europejskiej destynacji turystycznej.\n" +
//                "\n" +
//                "Za Wrocławiem znalazły się między innymi: hiszpańskie Bilbao, francuski Colmar, chorwacki Hvar, łotewska Ryga, czy też Mediolan, Amsterdam, Ateny i Paryż. Jedyny reprezentant Polski w tegorocznej edycji konkursu otrzymał głosy ze 146 krajów.\n" +
//                "\n" +
//                "Sprawdź: Wyniki European Best Destination 2018\n" +
//                "\n" +
//                "– Jestem niezwykle dumny. Chcę serdecznie podziękować wszystkim wrocławianom oraz kochającym to miasto turystom za każdy oddany głos. Zwycięstwo w tak prestiżowym konkursie świadczy o tym, że Wrocław już jest wśród najatrakcyjniejszych kierunków turystycznych na mapie Europy – powiedział Prezydent Wrocławia, Rafał Dutkiewicz.\n" +
//                "\n" +
//                "W poprzednich latach konkurs ten wygrywały m.in. Porto, Bordeaux, Lizbona i Kopenhaga. Za każdym razem wiązało się to z większym zainteresowaniem międzynarodowych mediów, a co za tym idzie również zwiększeniem ruchu turystycznego.\n" +
//                "\n" +
//                "Wrocław o zwycięstwo walczył do samego końca. Po dwóch tygodniach, na kilka dni przed zamknięciem internetowego głosowania, był w czołowej piątce miast, obok takich destynacji, jak: Colmar (Francja), Hvar (Chorwacja), Bilbao (Hiszpania) i Ryga (Łotwa).", date3, miasta, wroclaw);
//        Article article4 = new Article("Hawaje - rajskie wyspy w kolorach tęczy", "Hawaje leżą na Oceanie Spokojnym, w skład archipelagu wchodzi 8 wysp (Oahu, Niihau, Kauai, Maui, Molokai, Kahoolawe, Hawaii, Lanai). Wszystkie razem należą do USA i zostały nazwane stanem Aloha. Stolicą oraz głównym miastem jest Honolulu\n" +
//                "Hawaje. Honolulu - samotna metropolia\n" +
//                "\n" +
//                "\n" +
//                "\n" +
//                "Hawaje - gdyby w Stanach Zjednoczonych zaadresować list \"Raj Na Ziemi\", prawdopodobnie zawędrowałby prosto do Honolulu - stolicy Hawajów leżącej na Oahu, najbardziej turystycznej wyspie tego archipelagu Pacyfiku. Dla Amerykanów Hawaje to miejsce wymarzonych wakacji. Czy na Hawajach można robić coś innego poza leżeniem na słynnej (i podobno najpiękniejszej na Ziemi) plaży Waikiki? Jak najbardziej! Hawaje zapraszają!\n" +
//                "\n" +
//                "Hawaje - to raj \n" +
//                "\n" +
//                "Hawaje - rajski archipelag o długości 2400 km, składa się ze 136 wysp, wysepek i atoli. I choć z tej liczby tylko osiem wysp po wschodniej stronie ma znaczenie turystyczne, to stanowią one aż 99 proc. jego powierzchni. O sławie tego zakątka Ziemi zdecydował klimat i krajobraz. Średnia roczna temperatura waha się od 26 stopni C \"zimą\" do 31 latem. A krajobrazy? Nawet na Oahu, chyba najmniej uroczej wyspie, jest mnóstwo zaczarowanych miejsc, poza gigantycznym zapleczem hotelowym, które tworzy Honolulu - stolicę 51. stanu USA, największą (i najczęściej jedyną) noclegownię dla turystów, których jest tu bardzo dużo, zwłaszcza od połowy grudnia do kwietnia. Doba w dwuosobowym apartamencie (hotel 3-gwiazdkowy) kosztuje ok. 40-50 dol. Tańszych hoteli jest mniej, bo i zapotrzebowanie na nie jest dużo mniejsze - jeśli kogoś stać, by tu przylecieć, to nie szuka wakacji pod gruszą, ale raczej pod palmą na plaży, w bliskim sąsiedztwie baru z napojami chłodzącymi. Hawaje słyną z czterokilometrowej plaży Waikiki zapewnia te wygody, łącznie z bajecznie ciepłym i czystym oceanem i z falami wymarzonymi na surfing. To właśnie na Hawajach wymyślono ten sport, a na świecie upowszechnił go mistrz olimpijski Duke Kahanamoku - tubylec archipelagu. Należy pamiętać, że Hawaje, choć są częścią Stanów, historycznie należą do wielkiej rodziny narodów polinezyjskich, tzn. należały. Po dwustu latach, które upłynęły od czasu odkrycia wysp przez kapitana Cooka w 1778 r., z 300 tys. rodzimych mieszkańców pozostał tysiąc. Reszta została ucywilizowana... na wieki.\n" +
//                "\n" +
//                "Hawaje - jeśli przesyt słońca, plaży i soli w gardle po \"topieniu się\" w czasie nauki surfingu (deski można wypożyczyć na każdym kroku, gorzej z instruktorami) wygonią nas do miasta Honolulu, zagłębimy się w swojski labirynt pasaży handlowych, z mało swojskimi cenami, bo większość sklepów nastawiona jest na markowe wyroby światowych firm oraz na japońskich turystów, którzy je kupują. Bardziej ambitni mogą się wybrać do historycznego centrum stolicy, szczycącej się jedynym autentycznym pałacem królewskim na obecnym terytorium USA - Iolani. Wybudował go król Kalakaua w 1882 r., w czasach gdy Hawaje były niepodległym królestwem zamieszkanym głównie przez rdzennych Hawajczyków. Niedaleko pałacu wznosi się pozłacany pomnik pierwszego Hawajskiego króla Kamehamehy Wielkiego, który zaopatrzony w broń palną europejskich przybyszów zjednoczył Hawaje pod swoim berłem, zdobywając wyspę za wyspą. W pałacu tym mieszkała ostatnia królowa niepodległego państwa - Liliukalani. W 1898 r., w wyniku spisku białych właścicieli plantacji USA zostały \"zmuszone\" do udzielenia \"bratniej pomocy\" prześladowanym plantatorom, i anektując Hawaje, zastąpiły zacofaną monarchię postępową demokracją.\n" +
//                "\n" +
//
//                "Hawaje - a jeśli po pobycie na Big Island serce wytrzyma następną dawkę wrażeń, to pozostają jeszcze do zwiedzenia następne, równie piękne Hawajskie wyspy - Maui i Kauai...\n",date4, podroze, hawaje );
//        Article article5 = new Article("Metallica gives you heaven babe", "Metallica – amerykański zespół heavymetalowy założony w Los Angeles w 1981 roku przez Jamesa Hetfielda i Larsa Ulricha. Uważany za jeden z najważniejszych, najbardziej wpływowych zespołów metalowych lat 80. XX wieku, w latach 90. ubiegłego stulecia za najbardziej dochodowy zespół metalowy, a także za jeden z najpopularniejszych i najwybitniejszych zespołów heavymetalowych w dziejach. Według danych szacunkowych, nakład ze sprzedaży wszystkich wydawnictw muzycznych Metalliki na całym świecie wyniósł ponad 150[5] –200 milionów egzemplarzy[6], zgodnie z oficjalnym raportem International Federation of the Phonographic Industry z 2006 roku – międzynarodowej i jedynej na świecie organizacji przemysłu muzycznego, która zlicza sprzedaż formatów wydawniczych z całego globu. Tym samym, Międzynarodowa Federacja Przemysłu Fonograficznego uznała zespół formacją heavymetalową z największą liczbą sprzedanych wydawnictw muzycznych w historii, zgodnie ze wszystkimi oficjalnymi certyfikatami sprzedaży. Są również dziewiątymi artystami (a trzynastymi w klasyfikacji generalnej obok Led Zeppelin i Julio Iglesiasa), którzy sprzedali najwięcej płyt w historii muzyki. W samych Stanach Zjednoczonych, według Recording Inustry Association of America, zrzeszenia wydawców fonografii przyznającego oficjalne certyfikaty za sprzedaż płyt i singli w USA nakład ze sprzedaży płyt zespołu przekroczył 99 milionów 500 tysięcy kopii. Od 1991 roku w Polsce sprzedaż albumów Metalliki sięgnęła liczby 766 tysięcy egzemplarzy według Związku Producentów Audio-Video, przyznającego oficjalne certyfikaty za sprzedaż wydawnictw muzycznych. Czyni ich to drugimi zagranicznymi artystami, po zespole Queen, z największą liczbą sprzedanych płyt w Polsce[8]. Zespół jest jedną z najbardziej dochodowych grup muzycznych ostatnich trzech dekad pod względem sprzedaży koncertów. Do 2014 roku Metallica zarobiła na trasach koncertowych 433 miliony dolarów.\n" +
//                "\n" +
//                "Po wydaniu w 1983 r. debiutanckiego albumu Kill ’Em All Metallica została uznana za twórcę nowego stylu muzyki metalowej – thrash metalu. Zarazem wydany w 1986 r. trzeci album, Master of Puppets, jest określany przez niektórych krytyków jako najlepszy album heavymetalowy wszech czasów. Jest to również ostatni album zespołu nagrany z basistą Cliffem Burtonem, który zginął 27 września 1986 r. w wypadku autokarowym. Chociaż pozostali członkowie zespołu rozważali rozwiązanie grupy, to ostatecznie postanowili kontynuować działalność i na następcę Burtona został wybrany Jason Newsted.\n" +
//                "\n" +
//                "Album Metallica (nazywany też Czarnym Albumem) został wydany w 1991 r. i do dziś pozostaje najpopularniejszym wydawnictwem zespołu, który zdobył m.in. status diamentowej płyty w USA za sprzedaż w nakładzie ponad 16 milionów egzemplarzy według Nielsen SoundScan, źródła monitorującego sprzedaż płyt i singli w Stanach Zjednoczonych. Na całym świecie nakład wydawnictwa sięgnął liczby 30 milionów albumów. Jest to najlepiej sprzedająca się płyta heavymetalowa wszech czasów i plasuje się na 28. miejscu najlepiej sprzedających się albumów muzycznych w historii. Jest to również najlepiej sprzedająca się płyta ostatnich trzech dekad w Stanach Zjednoczonych, według oficjalnych danych gromadzonych przez Nielsen SoundScan. W 1999 roku Metallica zagrała wspólny koncert z Orkiestrą Symfoniczną z San Francisco dyrygowaną przez Michaela Kamena, który został podsumowany wydaniem albumu i filmu o nazwie S&M.\n" +
//                "\n" +
//                "W styczniu 2001 r. basista Jason Newsted opuścił grupę[. W kwietniu tego samego roku zespół rozpoczął nagrania do kolejnego albumu studyjnego, ale przerwał je w lipcu, gdy James Hetfield udał się do kliniki odwykowej, w której przebywał do grudnia[potrzebny przypis]. Pracę nad albumem wznowiono dopiero w maju 2002 r., co wreszcie w roku 2003 zaowocowało wydaniem albumu St. Anger. Wszystkie partie gitary basowej zostały nagrane przez producenta albumu Boba Rocka, ale jeszcze na kilka miesięcy przed wydaniem płyty nowym basistą Metalliki został Robert Trujillo. 12 września 2008 r. został wydany kolejny album studyjny zespołu, Death Magnetic.\n" +
//                "\n" +
//                "Zespół został sklasyfikowany na 3. pozycji listy zestawiającej Najlepsze Zespoły Metalowe Wszech Czasów sporządzonej przez MTV oraz na 5. pozycji listy zestawiającej 100 Najlepszych Artystów Hard Rocka sporządzonej przez VH1. W 2009 roku Metallica została wprowadzona do Rock and Roll Hall of Fame.", date5, music, metallica);
//
//
//
//        articleRepository.saveCategory(miasta);
//        articleRepository.saveCategory(music);
//        articleRepository.saveCategory(podroze);
//        articleRepository.saveCategory(security);
//        articleRepository.saveCategory(konsole);
//
//        articleRepository.saveArticle(article1);
//        articleRepository.saveArticle(article2);
//        articleRepository.saveArticle(article3);
//        articleRepository.saveArticle(article4);
//        articleRepository.saveArticle(article5);


        RequestDispatcher dispatcher = req.getRequestDispatcher("/antynews/MainPage.jsp");
        dispatcher.forward(req, resp);
    }
}




