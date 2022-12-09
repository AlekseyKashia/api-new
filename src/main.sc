require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /



    state: quote
        a: Цитата: {{$session.quoteText}}. А ее автор: {{$session.quoteAuthor}}.
        event: noMatch || onlyThisState = false, toState = "/start"

    state: start
        q!: $regex</start>
        HttpRequest: 
            url = http://host1848748.hostland.pro/zapros.php/?oper=2&info=1
            method = GET
            dataType = json
            okState = /quote
            errorState = /errorState
            timeout = 0
            vars = [{"name":"quoteText","value":"$httpResponse.quoteText"},{"name":"quoteAuthor","value":"$httpResponse.quoteAuthor"}]
            body = 
            headers = [{"name":"","value":""}]