import { browser, by, element } from 'protractor';

describe('Family-Todo Register', function() {
    it('should have register', function() {
        browser.get('/register');
        expect(element(by.css('h2')).getText()).toEqual('Register'); 
    });


      it('should go redirect to the right page after writing wrong credentials', () => {
            browser.get('/register');
            expect(element(by.css('h2')).getText()).toEqual('Login');
        
            element(by.css('[name=username]')).sendKeys('valami');
            element(by.css('[name=password]')).sendKeys('va');
            element(by.css('[type=submit]')).click();
        
            expect(element(by.css('h2')).getText()).toEqual('Register');
          });
  });