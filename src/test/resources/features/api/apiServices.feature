Feature: API title

  Scenario: Successful getting of title response
    When I send get service info request for course number '2' and I see 200 status code and title 'Інтернет-програміст (Frontend, Java Script)'

    Scenario: Successful getting of a service organization name title
      When I send get service info request for course number '1' and I see 200 status code and organization name 'Vinnytsia IT Academy'